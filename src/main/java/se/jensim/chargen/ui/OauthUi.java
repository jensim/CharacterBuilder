/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.ui;

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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import se.jensim.chargen.persistence.entities.FrontPageNews;
import se.jensim.chargen.persistence.entities.OauthProvider;
import se.jensim.chargen.persistence.entities.RollspelStatus;
import se.jensim.chargen.persistence.entities.RollspelUser;
import se.jensim.chargen.persistence.entities.RollspelUserRole;
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

			OauthProvider provider = entityManager.find(OauthProvider.class, id);

			String accessToken = getAccessToken(provider.getAccessTokenUrl(), provider.getClientId(), provider.getClientSecret(), code);
			String userID = getUser(provider.getUserUrl(), accessToken);

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

			String strRand = "fisk";//getSimplePass();
			System.out.println("TEMP PASS: " + strRand);

			//MD5-convertera skiten
			String strRandMd5 = MD5(strRand);
			System.out.println("MD5 HEX PASS: " + strRandMd5);

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
		}
	}

	private String getAccessToken(String accessTokenUrl, String client_id, String client_secret, String code) throws Exception {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("client_id", client_id);
		parameterMap.put("client_secret", client_secret);
		parameterMap.put("code", code);
		String parameterSet = HttpTool.getParamString(parameterMap);

		String response = HttpTool.postRequest(accessTokenUrl, parameterSet);
		System.out.println("RESPONSE: " + response);
		String token = response.split("access_token=")[1].split("&")[0];
		System.out.println("TOKEN: " + token);

		return token;
	}

	private String getUser(String userUrl, String accessToken) throws Exception {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("access_token", accessToken);
		String parameterSet = HttpTool.getParamString(parameterMap);

		String response = HttpTool.getRequest(userUrl, parameterSet);
		System.out.println("RESPONSE: " + response);
		String token = response.split("\"id\":")[1].split("[,}]")[0];

		return token;
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
