package br.com.triadworks.bugtracker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Bug;
import br.com.triadworks.bugtracker.modelo.Status;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@Controller
@Scope("request")
public class BugBean {

	private Bug bug = new Bug();
	private List<Bug> bugs = new ArrayList<Bug>();
	private List<Usuario> usuarios ;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private BugDao dao;
	
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public List<Usuario> getUsuarios() {
		if(usuarios==null){
			this.usuarios = usuarioDao.lista();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	
	
	@PostConstruct
	public void init() {
		this.bug.setResponsavel(new Usuario());
	}
	
	public void salva() {
		dao.salva(bug);
		this.bug = new Bug();
		new FacesUtils().adcionaMensagemSucesso("Bug adicionado com sucesso!");
	}
	
	public List<Status> getTodosOsStatus() {
		return Arrays.asList(Status.values());
	}
	
	public void lista(){
		this.bugs = dao.lista();
	}
	
	public void remove(Bug bug){
		dao.remove(bug);
		this.bugs = dao.lista();
		new FacesUtils().adcionaMensagemSucesso("Bug removido com sucesso");
	}
	
	public Bug getBug() {
		return this.bug;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}
}