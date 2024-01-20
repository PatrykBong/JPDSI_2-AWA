package com.jsfcourse.login;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.simplesecurity.RemoteClient;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.jsf.dao.UzytkownikDAO;
import com.jsf.entities.Uzytkownik;

@Named
@RequestScoped
public class LoginBB {
	private static final String PAGE_MAIN = "/pages/app/personList?faces-redirect=true";
	private static final String PAGE_LOGIN = "/pages/login";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String login;
	private String pass;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Inject
	UzytkownikDAO userDAO;

	public String doLogin() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		// 1. verify login and password - get User from "database"
		Uzytkownik uzytkownik = null;
		List <Uzytkownik> uzytkownicy = userDAO.getFullList();
		for(Uzytkownik uzytk : uzytkownicy){
			if(uzytk.getHaslo().equals(pass) && uzytk.getNick().equals(login)) {
				uzytkownik = new Uzytkownik();
				uzytkownik.setNick(login);
				uzytkownik.setRola(uzytk.getRola());
			}
		}

		// 2. if bad login or password - stay with error info
		if (uzytkownik == null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Niepoprawny login lub hasło", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		// 3. if logged in: get User roles, save in RemoteClient and store it in session
		
		RemoteClient<Uzytkownik> client = new RemoteClient<Uzytkownik>(); //create new RemoteClient
		client.setDetails(uzytkownik);
		
		client.getRoles().add(uzytkownik.getRola());
		//client.getRoles().add("NIE_MA_ROLI_I_DZIALA");
	
		//store RemoteClient with request info in session (needed for SecurityFilter)
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		client.store(request);

		// and enter the system (now SecurityFilter will pass the request)
		return PAGE_MAIN;
	}
	
	public String doLogout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		//Invalidate session
		// - all objects within session will be destroyed
		// - new session will be created (with new ID)
		session.invalidate();
		return PAGE_LOGIN;
	}
	
}
