package se.jensim.chargen.ui;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@CDIUI("")
public class WelcomeUI extends UI {

	private static final long serialVersionUID = 1511280419027917279L;

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		Label lbl = new Label("", ContentMode.HTML);
		Button btn = new Button("BUTTON");//, this);
		VerticalLayout layout = new VerticalLayout(lbl, btn);
		setContent(layout);
	}
/*
	@Override
	public void buttonClick(ClickEvent event) {
		Notification.show("Button was clicked. Good Work!...");

	}
*/
}
