package br.com.getup.testlogin.util.servletfilter;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MarkusPatriota
 */
public class LoginPhaseListener implements PhaseListener{
    
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        
        boolean isLoginPage = (currentPage.lastIndexOf("home.xhtml") > -1);
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object currentUser = session.getAttribute("usuario");
        
        if (!isLoginPage && currentUser == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "homePage");
        }
    }
    
    @Override
    public void beforePhase(PhaseEvent event) {

    }
    
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
