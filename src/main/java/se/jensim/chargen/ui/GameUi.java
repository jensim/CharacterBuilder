/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.ui;

import com.sun.corba.se.spi.extension.ZeroPortPolicy;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import se.jensim.chargen.view.ViewZero;

/**
 *
 * @author jens
 */
@CDIUI("game")
@RolesAllowed({"admin", "user"})
public class GameUi extends UI{
    
    @Inject
    private CDIViewProvider provider;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout vlMain = new VerticalLayout();
        setContent(vlMain);
        Navigator nav = new Navigator(this, vlMain);
		nav.addProvider(provider);
		nav.setErrorView(ViewZero.class);
    }
}
