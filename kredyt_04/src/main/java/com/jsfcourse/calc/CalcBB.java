package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private Integer kwota;
	private Integer lata;
	private Double procent;
	private Double wynik;

	@Inject
	FacesContext ctx;
	
	public Integer getKwota() {
		return kwota;
	}

	public void setKwota(Integer kwota) {
		this.kwota = kwota;
	}

	public Integer getLata() {
		return lata;
	}

	public void setLata(Integer lata) {
		this.lata = lata;
	}

	public Double getProcent() {
		return procent;
	}

	public void setProcent(Double procent) {
		this.procent = procent;
	}

	public Double getWynik() {
		return wynik;
	}

	public boolean doTheMath() {
		try {
			double kw = this.kwota;
			double lt = this.lata;
			double pr = this.procent;
			
			for(int i=0;i<lt;i++){
				kw=kw*(1+pr/100);
			}
			wynik = kw/(12*lt);
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true; 
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false; 
		}
	}
	
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
	
	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + wynik, null));
		}
		return null;
	}
}




