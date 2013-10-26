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
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;
import se.jensim.chargen.persistence.entities.OauthProvider;
import se.jensim.chargen.persistence.entities.RollspelUser;

/**
 *
 * @author jens
 */
@UIScoped
public class MutantCreateCharacter extends Window
		implements WizardProgressListener {

	@Inject
	private JaasAccessControl accessControl;
	@PersistenceContext
	private EntityManager entityManager;
	@Inject
	private MCCSelectRace stepClass;

	private final Wizard wiz = new Wizard();

	private MutantCreateCharacter() {
		super("Mutant, Create character");
	}

	@PostConstruct
	private void init() {
		//TODO
		wiz.addStep(stepClass);

		wiz.addListener(this);

		setContent(wiz);

		setModal(true);
		center();
	}

	@Override
	public void activeStepChanged(WizardStepActivationEvent event) {
		setSizeUndefined();
	}

	@Override
	public void stepSetChanged(WizardStepSetChangedEvent event) {
	}

	@Override
	public void wizardCompleted(WizardCompletedEvent event) {
		//TODO
	}

	@Override
	public void wizardCancelled(WizardCancelledEvent event) {
		//TODO
	}
}
