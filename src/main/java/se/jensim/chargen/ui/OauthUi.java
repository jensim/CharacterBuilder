/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.jensim.chargen.ui;

import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jens
 */
@CDIUI("oauth")
public class OauthUi extends UI {
    
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private JaasAccessControl accessControl;

    @Override
    protected void init(VaadinRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        
        if (!parameterMap.containsKey("provider")){
            setContent(new Label("Missing data 'provider'.", ContentMode.HTML));
            return;
        }else if(!parameterMap.containsKey("code")){
            setContent(new Label("Missing data 'code'.", ContentMode.HTML));
            return;
        }else{
            setContent(new Label("Welcome, auth commencing", ContentMode.HTML));
        }
        //TODO: AUTH
        
    }
}
