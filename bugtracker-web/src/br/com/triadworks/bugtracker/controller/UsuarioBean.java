package br.com.triadworks.bugtracker.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@Controller
@Scope("request")
public class UsuarioBean {
  
	
 
  @Autowired
  private UsuarioDao dao;
  private Usuario usuario = new Usuario() ;
  private List<Usuario> usuarios;
  
  public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
  
  public Usuario getUsuario() {
	return usuario;
}



public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}



public List<Usuario> getUsuarios() {
	return usuarios;
}



public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}



public void adiciona(){
	  dao.adiciona(this.usuario);
	  this.usuario = new Usuario();
	  new FacesUtils().adcionaMensagemSucesso("Usuario adicionado com sucesso !");
	 	  
  }

public void lista(){
	  this.usuarios = dao.lista();
	  
	 	  
}

public void remover(Usuario usuario){
	  dao.remove(usuario);
	  this.usuarios = dao.lista();
	  new FacesUtils().adcionaMensagemSucesso("Usuario removido com sucesso !");
	  	 	  
}
public void edita(){
	dao.atualiza(usuario);
}
	
}
