package se.jensim.chargen.gui.menu;

import com.vaadin.cdi.UIScoped;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Window;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import se.jensim.chargen.gui.mutant.character.create.MutantCreateCharacter;
import se.jensim.chargen.prop.ConstRoles;
import se.jensim.chargen.prop.ConstViews;

/**
 *
 * @author jens
 */
@UIScoped
@RolesAllowed({ConstRoles.USER, ConstRoles.MODERATOR, ConstRoles.MODERATOR, ConstRoles.OWNER})
public class ChargenMenu extends HorizontalLayout {

	private final MenuBar leftMenu = new MenuBar();
	private final MenuBar rightMenu = new MenuBar();
	@Inject
	private JaasAccessControl accessControl;
	@Inject
	private MutantCreateCharacter windowCreateCharacter;

	private ChargenMenu() {
	}

	@PostConstruct
	private void init() {
		String userName = accessControl.getPrincipalName();
		//SETUP LEFT
		leftMenu.addItem("Start", new CharNavCmd(ConstViews.START));
		MenuItem miMutant = leftMenu.addItem("Mutant", null);

		miMutant.addItem("Create character",
				new CharWindowCmd(windowCreateCharacter));
		miMutant.addItem("List characters",
				new CharNavCmd(ConstViews.MUTANT_CHAR_LIST));

		if (accessControl.isUserInSomeRole(ConstRoles.ADMIN, ConstRoles.OWNER)) {
			//TODO: Add admin options
		}

		MenuItem miTrudvang = leftMenu.addItem("Trudvang", null);

		//SETUP RIGHT
		rightMenu.addItem("Logout(" + userName + ")", new CharNavCmd(ConstViews.LOGOUT));

		//GUI and such
		addComponent(leftMenu);
		addComponent(rightMenu);
		setWidth("100%");
		leftMenu.setWidth("100%");
		setExpandRatio(leftMenu, 1);
		rightMenu.setWidth("100%");
		setExpandRatio(rightMenu, 0);
	}

	private class CharNavCmd implements Command {

		private final String navStr;

		public CharNavCmd(String navigationString) {
			this.navStr = navigationString;
		}

		@Override
		public void menuSelected(MenuBar.MenuItem selectedItem) {
			getUI().getPage().setUriFragment("!" + navStr);
		}
	}

	private class CharWindowCmd implements Command {

		private final Window wind;

		public CharWindowCmd(Window w) {
			this.wind = w;
		}

		@Override
		public void menuSelected(MenuItem selectedItem) {
			getUI().addWindow(wind);
		}
	}
}
