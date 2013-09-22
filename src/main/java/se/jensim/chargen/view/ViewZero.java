/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.view;

import se.jensim.chargen.prop.JeConst;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.security.RolesAllowed;
import se.jensim.chargen.prop.ConstRoles;
import se.jensim.chargen.ui.GameUi;

/**
 *
 * @author jens
 */
@CDIView(supportsParameters = false, uis = GameUi.class)
@RolesAllowed({ConstRoles.USER, ConstRoles.MODERATOR, ConstRoles.ADMIN, ConstRoles.OWNER})
public class ViewZero extends VerticalLayout implements View {

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		Label lblHead = new Label("<h1>Welcome</h1>", ContentMode.HTML);
		addComponent(lblHead);
	}
}
