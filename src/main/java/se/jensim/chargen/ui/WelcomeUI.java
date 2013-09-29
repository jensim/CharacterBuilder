package se.jensim.chargen.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.jensim.chargen.persistence.entities.OauthProvider;

@CDIUI("")
@Theme("chameleon")
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
		//layout.setSizeFull();
		layout.setSpacing(true);
		final Panel pnal = new Panel(layout);

		setContent(pnal);
		pnal.setSizeFull();

		Label lblWelcome = new Label("<center>Welcome to my roleplay portal<br/>\n"
				+ "Please select a method of signing in</center>", ContentMode.HTML);
		layout.addComponent(lblWelcome);
		layout.setComponentAlignment(lblWelcome, Alignment.TOP_CENTER);

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
							+ "&redirect_uri=" + getPage().getLocation().toString().split("\\?")[0]
							+ "oauth?id=" + provider.getId()
							+ "&response_type=code"
							+ "&scope=https://www.googleapis.com/auth/userinfo.profile"
							//+ "&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile"
							+ "&approval_prompt=auto";
				} else {
					redir = provider.getAuthorizeUrl()
							+ "?client_id=" + provider.getClientId()
							+ "&redirect_uri=" + getPage().getLocation().toString().split("\\?")[0]
							+ "oauth?id=" + provider.getId();
				}
				logger.info(redir);
				btn.setData(redir);
				layout.addComponent(btn);
				layout.setComponentAlignment(btn, Alignment.TOP_CENTER);
			}
		}

		Label lblInfo = new Label("<center><font color=\"gray\">Clicking a button will redirect you<br/>\n"
				+ "to perform authentication at the<br/>\n"
				+ "selected login site.</font></center>", ContentMode.HTML);
		layout.addComponent(lblInfo);
		layout.setComponentAlignment(lblInfo, Alignment.TOP_CENTER);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		getPage().setLocation(event.getButton().getData().toString());
	}
}
