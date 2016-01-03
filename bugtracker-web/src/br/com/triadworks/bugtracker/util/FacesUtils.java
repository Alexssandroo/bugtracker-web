package br.com.triadworks.bugtracker.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {

	private FacesContext ctx;

	public FacesUtils() {
		this.ctx = FacesContext.getCurrentInstance();
	}
 public void adcionaMensagemSucesso(String mensagem){
	 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
	 ctx.addMessage(null, msg);
	 
 }
 public void adcionaMensagemErro(String mensagem){
	 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
	 ctx.addMessage(null, msg);
	 
 }
	
}
