/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.gui.mutant.character.create;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.vaadin.teemu.wizards.WizardStep;
import se.jensim.chargen.persistence.entities.MutantClass;

/**
 *
 * @author jens
 */
@UIScoped
public class MCCSelectRace extends VerticalLayout
		implements WizardStep, Property.ValueChangeListener {

	@PersistenceContext
	private EntityManager entityManager;
	private JPAContainer<MutantClass> container;
	private NativeSelect select = null;
	private final Label lblInfo = new Label("", ContentMode.HTML);
	private final Panel pnlInfo = new Panel(null, lblInfo);

	private MCCSelectRace() {
	}

	public MCCSelectRace(EntityManager em) {
		this.entityManager = em;
	}

	@PostConstruct
	private void init() {
		//TODO
		container = JPAContainerFactory.make(MutantClass.class, entityManager);
		select = new NativeSelect(null, container);
		select.setNullSelectionAllowed(false);
		select.setMultiSelect(false);
		select.setItemCaptionMode(AbstractSelect.ItemCaptionMode.ITEM);
		select.addValidator(new NullValidator("Selction is mandatory", false));
		select.addValueChangeListener(this);
		select.setImmediate(true);
		select.select(container.firstItemId());

		addComponent(select);
		addComponent(pnlInfo);
	}

	@Override
	public String getCaption() {
		return "Character class";
	}

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public boolean onAdvance() {
		try {
			select.validate();
			return true;
		} catch (Validator.InvalidValueException e) {
			return false;
		}
	}

	@Override
	public boolean onBack() {
		return true;
	}

	@Override
	public void valueChange(Property.ValueChangeEvent event) {
		MutantClass klass = container.getItem(event.getProperty().getValue()).getEntity();
		if (klass == null) {
			Notification.show("FEL", "SO WRUNG", Notification.Type.ERROR_MESSAGE);
		}
	}
}
