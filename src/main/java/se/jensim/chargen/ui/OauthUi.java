/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.ui;

import com.google.gwt.core.client.JavaScriptObject;
import java.util.List;

import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import elemental.js.util.Json;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.codehaus.jackson.map.ObjectMapper;
import se.jensim.chargen.persistence.entities.OauthProvider;
import se.jensim.chargen.persistence.entities.RollspelStatus;
import se.jensim.chargen.persistence.entities.RollspelUser;
import se.jensim.chargen.persistence.entities.RollspelUserRole;
import se.jensim.tools.GoogleAuthHelper;
import se.jensim.tools.HttpTool;

/**
 *
 * @author jens
 */
@CDIUI("oauth")
public class OauthUi extends UI {

	private final Logger logger = LoggerFactory.getLogger(OauthUi.class);
	private final SecureRandom random = new SecureRandom();
	@PersistenceContext
	private EntityManager entityManager;
	@Resource
	private UserTransaction userTransaction;
	@Inject
	private JaasAccessControl accessControl;

	@Override
	protected void init(VaadinRequest request) {
		try {

			Map<String, String[]> parameterMap = request.getParameterMap();

			if (!parameterMap.containsKey("id")) {
				setContent(new Label("Missing data 'provider'.", ContentMode.HTML));
				return;
			} else if (!parameterMap.containsKey("code")) {
				setContent(new Label("Missing data 'code'.", ContentMode.HTML));
				return;
			} else {
				setContent(new Label("Welcome, auth commencing", ContentMode.HTML));
			}
			//TODO: AUTH
			String strID = parameterMap.get("id")[0];
			if (!strID.matches("\\d+")) {
				throw new Exception();
			}
			Integer id = Integer.parseInt(strID);
			String code = parameterMap.get("code")[0];
			System.out.println("CODE: " + code);

			OauthProvider provider = entityManager.find(OauthProvider.class, id);

			String userID;
			if (provider.getName().equalsIgnoreCase("google")) {
				GoogleAuthHelper helper = new GoogleAuthHelper(
						provider.getClientId(),
						provider.getClientSecret(),
						getPage().getLocation().toString().split("\\?")[0] + "?id=" + id);
				String userInfo = helper.getUserInfoJson(code);
				System.out.println(userInfo);
				HashMap<String, Object> result =
						new ObjectMapper().readValue(userInfo, HashMap.class);
				if (result.containsKey("id")) {
					userID = result.get("id").toString();
				} else {
					throw new Exception("No id from google");
				}
			} else {
				//ACCESS TOKEN
				Map<String, String> tokenMap = new HashMap<String, String>();
				tokenMap.put("client_id", provider.getClientId());
				tokenMap.put("client_secret", provider.getClientSecret());
				tokenMap.put("code", code);

				String parameterSet = HttpTool.getParamString(tokenMap);
				String response = HttpTool.postRequest(provider.getAccessTokenUrl(), parameterSet);
				System.out.println("RESPONSE: " + response);

				String accessToken;
				if (response.contains("{\"")) {
					HashMap<String, Object> result =
							new ObjectMapper().readValue(response, HashMap.class);
					if (result.containsKey("id")) {
						accessToken = result.get("id").toString();
					} else {
						throw new Exception("No id from google");
					}
				} else {
					accessToken = response.split("access_token=")[1].split("&")[0];
				}
				System.out.println("TOKEN: " + accessToken);

				//USER ID
				userID = getUser(provider.getUserUrl(), accessToken);
				System.out.println("USERID: " + userID);
			}
			//Check if the user is registered already..
			List<RollspelUser> userList = entityManager.createQuery("SELECT u FROM " + RollspelUser.class.getCanonicalName()
					+ " u JOIN u." + RollspelUser.OAUTH_PROVIDER + " p "
					+ " WHERE u." + RollspelUser.OAUTH_USER_ID + " = :user_id "
					+ " AND p." + OauthProvider.ID + " = :provider_id", RollspelUser.class)
					.setParameter("user_id", userID).setParameter("provider_id", id).getResultList();
			RollspelUser user = null;
			if (userList.isEmpty()) {
				//TODO Create user first;
				userTransaction.begin();
				user = new RollspelUser();
				user.setOauthProviderId(provider);
				user.setOauthProviderUserId(userID);
				user.setEmail(userID + "@" + provider.getName());

				RollspelStatus status = entityManager.find(RollspelStatus.class, 2);
				user.setStatusId(status);
				RollspelUserRole role = entityManager.find(RollspelUserRole.class, 1);
				user.setUserRoleId(role);

				entityManager.persist(user);

				userTransaction.commit();

				Notification.show("Welcome", "first-timer", Notification.Type.HUMANIZED_MESSAGE);
			} else {
				user = userList.get(0);
			}
			if (user == null) {
				throw new Exception();
			}

			//TODO Set new random password

			String strRand = getSimplePass();

			//MD5-convertera skiten
			String strRandMd5 = MD5(strRand);

			userTransaction.begin();
			RollspelUser user2 = entityManager.find(RollspelUser.class, user.getId());
			user2.setPassword(strRandMd5);
			userTransaction.commit();

			JaasAccessControl.login(user.getEmail(), strRand);
			if (accessControl.isUserSignedIn()) {

				getPage().setLocation("game");
			} else {
				getPage().setLocation("..");
			}
		} catch (Exception ex) {
			if (ex.getCause() != null) {
				ex.getCause().printStackTrace();
			} else {
				ex.printStackTrace();
			}
			setContent(new Label("<h1>error</h1>", ContentMode.HTML));
			getPage().setLocation("../?failed=true");
		}
	}

	private String getUser(String userUrl, String accessToken) throws Exception {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("access_token", accessToken);
		String parameterSet = HttpTool.getParamString(parameterMap);

		String response = HttpTool.getRequest(userUrl, parameterSet);
		System.out.println("RESPONSE: " + response);
		String idRegex = "\"id\":";
		if (!response.contains(idRegex)) {
			throw new Exception("Response from server did not contain a user id");
		}

		String id = response.split(idRegex)[1].split("[,}]")[0];

		return id;
	}

	private String byteToHex(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (byte by : b) {
			sb.append(String.format("%02X", by));
		}
		return sb.toString();
	}

	public String MD5(String md5) throws Exception {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		md.reset();
		byte[] array = md.digest(md5.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();

	}

	public String getSimplePass() {
		return new BigInteger(130, random).toString(32);
	}
}
