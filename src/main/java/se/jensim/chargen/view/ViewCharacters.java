package se.jensim.chargen.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import se.jensim.chargen.prop.ConstRoles;
import se.jensim.chargen.ui.GameUi;

/**
 *
 * @author jens
 */
@CDIView(uis = GameUi.class, value = "chars")
@RolesAllowed({ConstRoles.USER, ConstRoles.MODERATOR, ConstRoles.ADMIN, ConstRoles.OWNER})
public class ViewCharacters extends VerticalLayout implements View {

	private final Label lblHead = new Label("<h1>HEAD</h1>", ContentMode.HTML);

	private ViewCharacters() {
	}

	@PostConstruct
	private void init() {
		addComponent(lblHead);
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
	}
}
