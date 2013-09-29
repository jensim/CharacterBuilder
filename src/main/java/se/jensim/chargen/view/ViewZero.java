/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import se.jensim.chargen.gui.menu.ChargenMenu;
import se.jensim.chargen.prop.ConstRoles;
import se.jensim.chargen.prop.ConstViews;
import se.jensim.chargen.ui.GameUi;

/**
 *
 * @author jens
 */
@CDIView(supportsParameters = false, uis = GameUi.class, value = ConstViews.START)
@RolesAllowed({ConstRoles.USER, ConstRoles.MODERATOR, ConstRoles.ADMIN, ConstRoles.OWNER})
public class ViewZero extends VerticalLayout implements View {

	@Inject
	private ChargenMenu menu;
	private Label lblHead = new Label("<h1>Welcome</h1>", ContentMode.HTML);

	public ViewZero() {
	}

	@PostConstruct
	private void init() {
		addComponent(menu);
		addComponent(lblHead);
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		
	}
}
