package se.jensim.chargen.ui;

import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.jensim.chargen.persistence.entities.OauthProvider;

@CDIUI("")
public class WelcomeUI extends UI implements Button.ClickListener {

	private static final long serialVersionUID = 1511280419027917279L;
	private final Logger logger = LoggerFactory.getLogger(WelcomeUI.class);
	@PersistenceContext
	private EntityManager entityManager;
	@Inject
	private JaasAccessControl accessControl;

	@Override
	protected void init(VaadinRequest request) {
		if (accessControl.isUserSignedIn()) {
			getPage().setLocation("game");
			return;
		}

		final VerticalLayout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.setSpacing(true);
		final Panel pnal = new Panel(layout);

		setContent(pnal);

		List<OauthProvider> providerList = entityManager.createQuery(
				"SELECT op FROM " + OauthProvider.class.getCanonicalName() + " op ", OauthProvider.class)
				.getResultList();
		for (OauthProvider provider : providerList) {
			if (provider.getActive()) {
				// TODO Auto-generated method stub

				Button btn = new Button(provider.getName(), this);
				String redir;
				if (provider.getName().equalsIgnoreCase("google")) {
					redir = provider.getAuthorizeUrl()
							+ "?client_id=" + provider.getClientId()
							+ "&redirect_uri=" + getPage().getLocation()
							+ "oauth?id=" + provider.getId()
							+ "&response_type=code"
							+ "&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile"
							+ "&approval_prompt=auto";
				} else {
					redir = provider.getAuthorizeUrl()
							+ "?client_id=" + provider.getClientId()
							+ "&redirect_uri=" + getPage().getLocation()
							+ "oauth? id=" + provider.getId();
				}
				logger.info(redir);
				btn.setData(redir);
				layout.addComponent(btn);
			}
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {
		getPage().setLocation(event.getButton().getData().toString());
	}
}
