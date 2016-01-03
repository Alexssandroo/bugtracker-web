package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.modelo.Bug;

@ManagedBean
@ViewScoped
public class TodosOsBugsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Bug> bugs;
	@ManagedProperty("#{bugDao}")
	private BugDao dao;
	
	
	@PostConstruct
	public void init(){
		this.bugs=dao.lista();
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	public BugDao getDao() {
		return dao;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}

	
	

}
