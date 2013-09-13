/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.ui;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import javax.annotation.security.RolesAllowed;

/**
 *
 * @author jens
 */
@CDIUI("game")
@RolesAllowed({"admin", "user"})
public class GameUi extends UI{

    @Override
    protected void init(VaadinRequest request) {
        
    }
    
}
