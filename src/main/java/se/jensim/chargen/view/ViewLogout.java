package se.jensim.chargen.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.ServletException;
import se.jensim.chargen.gui.menu.ChargenMenu;
import se.jensim.chargen.prop.ConstRoles;
import se.jensim.chargen.prop.ConstViews;
import se.jensim.chargen.ui.GameUi;

/**
 *
 * @author jens
 */
@CDIView(uis = GameUi.class, value = ConstViews.LOGOUT)
@RolesAllowed({ConstRoles.USER, ConstRoles.MODERATOR, ConstRoles.ADMIN, ConstRoles.OWNER})
public class ViewLogout extends VerticalLayout
		implements View, Button.ClickListener {

	@Inject
	private ChargenMenu menu;
	private final Label lblContent = new Label("Are you sure?", ContentMode.HTML);
	private final Button btnLogout = new Button("LOGOUT", this);
	
	private ViewLogout() {
	}

	@PostConstruct
	private void init() {
		addComponent(menu);
		addComponent(lblContent);
		addComponent(btnLogout);

	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
	}

	@Override
	public void buttonClick(Button.ClickEvent event) {
		if (event.getButton() == btnLogout) {
			try {
				JaasAccessControl.logout();
			} catch (ServletException ex) {
				Logger.getLogger(ViewLogout.class.getName()).log(Level.SEVERE, null, ex);
			}
			getUI().getPage().setLocation("..");
		}
	}
}
