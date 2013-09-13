package se.jensim.chargen.ui;

import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@CDIUI("")
public class WelcomeUI extends UI implements Button.ClickListener {

    private static final long serialVersionUID = 1511280419027917279L;
    
    //@PersistenceContext
    //private EntityManager entityManager;
    @Inject
    private JaasAccessControl accessControl;

    @Override
    protected void init(VaadinRequest request) {
        
        // TODO Auto-generated method stub
        Label lbl = new Label("", ContentMode.HTML);
        Button btn = new Button("Auth", this);
        VerticalLayout layout = new VerticalLayout(lbl, btn);
        setContent(layout);
        
        if(accessControl.isUserSignedIn()){
            getPage().setLocation("game");
        }
    }

    @Override
    public void buttonClick(ClickEvent event) {
        Notification.show("Button was clicked. Good Work!...");
        
    }
}
