package com.jsfcourse.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;

import com.jsf.dao.TypDAO;
import com.jsf.entities.Typ;

@Named
@RequestScoped
public class MojeTypyBB {
	private static final String PAGE_PERSON_EDIT = "personEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String surname;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	TypDAO typDAO;
		
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Typ> getFullList(){
		return typDAO.getFullList();
	}

	public List<Typ> getList(){
		List<Typ> list = null;
				
		list = typDAO.getFullList();
		
		return list;
	}

	/**public String newPerson(){
		Typ person = new Typ();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash	
		flash.put("person", person);
		
		return PAGE_PERSON_EDIT;
	}

	public String editPerson(Typ person){
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash 
		flash.put("person", person);
		
		return PAGE_PERSON_EDIT;
	}

	public String deletePerson(Typ person){
		typDAO.remove(person);
		return PAGE_STAY_AT_THE_SAME;
	}**/
}
