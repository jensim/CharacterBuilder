/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.gui.mutant.character.create;

import com.vaadin.cdi.UIScoped;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.ui.Window;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.vaadin.teemu.wizards.Wizard;
import se.jensim.chargen.persistence.entities.OauthProvider;
import se.jensim.chargen.persistence.entities.RollspelUser;

/**
 *
 * @author jens
 */
@UIScoped
public class MutantCreateCharacter extends Window {

	@Inject
	private JaasAccessControl accessControl;
	@PersistenceContext
	private EntityManager entityManager;
	private Integer userId;

	private final Wizard wiz = new Wizard();

	private MutantCreateCharacter() {
		super("Mutant, Create character");
	}

	@PostConstruct
	private void init() {
		String email = accessControl.getPrincipalName();
		String[] splitName = email.split("@");
		String providerUID = splitName[0];
		String providerID = splitName[1];
		userId = entityManager.createQuery("SELECT u." + RollspelUser.ID
				+ " FROM " + RollspelUser.class.getName() + " u "
				+ " JOIN u." + RollspelUser.OAUTH_PROVIDER + " p "
				+ " WHERE u." + RollspelUser.OAUTH_USER_ID
				+ " = :uid AND p." + OauthProvider.NAME + " = :pname", Integer.class)
				.setParameter("uid", providerUID)
				.setParameter("pname", providerID)
				.getSingleResult();
	}
}
