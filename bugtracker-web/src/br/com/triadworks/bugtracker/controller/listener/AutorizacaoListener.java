package br.com.triadworks.bugtracker.controller.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.triadworks.bugtracker.controller.UsuarioWeb;

public class AutorizacaoListener implements PhaseListener {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext ctx = event.getFacesContext();
		String paginaAcessada = ctx.getViewRoot().getViewId();
		if("/login.xhtml".equals(paginaAcessada)){
			return;
		}
		
		UsuarioWeb usuarioWeb = ctx.getApplication().evaluateExpressionGet(ctx,"#{usuarioWeb}",UsuarioWeb.class);
		
		if(!usuarioWeb.isLogado()){
			NavigationHandler handler = ctx.getApplication().getNavigationHandler();
			handler.handleNavigation(ctx, null, "/login?faces-redirect=true");
			ctx.renderResponse();			
		}
		

	}

	@Override
	public void beforePhase(PhaseEvent event) {
	
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

}
