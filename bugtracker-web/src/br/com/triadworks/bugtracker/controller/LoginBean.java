package br.com.triadworks.bugtracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.service.Autenticador;
import br.com.triadworks.bugtracker.util.FacesUtils;

@Controller
@Scope("request")
public class LoginBean {
	private String login;
	private String senha;
	private UsuarioWeb usuarioWeb;
	private Autenticador autenticador;
	
	@Autowired
	public LoginBean(Autenticador autenticador, UsuarioWeb usuarioWeb){
		this.autenticador= autenticador;
		this.usuarioWeb= usuarioWeb;
		
	}
	
	public void setAutenticador(Autenticador autenticador) {
		this.autenticador = autenticador;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public String logar(){
	
		Usuario usuario = autenticador.autentica(login, senha);
		if(usuario !=null){
			usuarioWeb.loga(usuario);
			return "/pages/usuario/lista?faces-redirect=true";
			
		}
		new FacesUtils().adcionaMensagemErro("Login ou senha inválidos");
		
		return null;
		
	}
	
	public String deslogar(){
		usuarioWeb.desloga();
		return "/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
