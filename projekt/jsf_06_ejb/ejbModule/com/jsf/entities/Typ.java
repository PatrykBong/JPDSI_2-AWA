package com.jsf.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


/**
 * The persistent class for the typ database table.
 * 
 */
@Entity
@NamedQuery(name="Typ.findAll", query="SELECT t FROM Typ t")
public class Typ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_typ")
	private int idTyp;

	private int punkty;

	private String typ;

	//bi-directional many-to-one association to Mecz
	@ManyToOne
	@JoinColumn(name="mecz")
	private Mecz meczBean;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	@JoinColumn(name="uzytkownik")
	private Uzytkownik uzytkownikBean;

	public Typ() {
	}

	public int getIdTyp() {
		return this.idTyp;
	}

	public void setIdTyp(int idTyp) {
		this.idTyp = idTyp;
	}

	public int getPunkty() {
		return this.punkty;
	}

	public void setPunkty(int punkty) {
		this.punkty = punkty;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public Mecz getMeczBean() {
		return this.meczBean;
	}

	public void setMeczBean(Mecz meczBean) {
		this.meczBean = meczBean;
	}

	public Uzytkownik getUzytkownikBean() {
		return this.uzytkownikBean;
	}

	public void setUzytkownikBean(Uzytkownik uzytkownikBean) {
		this.uzytkownikBean = uzytkownikBean;
	}

}