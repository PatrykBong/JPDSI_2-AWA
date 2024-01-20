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
 * The persistent class for the reprezentacja database table.
 * 
 */
@Entity
@NamedQuery(name="Reprezentacja.findAll", query="SELECT r FROM Reprezentacja r")
public class Reprezentacja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reprezentacja")
	private int idReprezentacja;

	private String nazwa;

	@Column(name="w_turnieju")
	private byte wTurnieju;

	//bi-directional many-to-one association to Mecz
	@OneToMany(mappedBy="reprezentacja1")
	private List<Mecz> meczs1;

	//bi-directional many-to-one association to Mecz
	@OneToMany(mappedBy="reprezentacja2")
	private List<Mecz> meczs2;

	//bi-directional many-to-one association to Uzytkownik
	@OneToMany(mappedBy="reprezentacja")
	private List<Uzytkownik> uzytkowniks;

	public Reprezentacja() {
	}

	public int getIdReprezentacja() {
		return this.idReprezentacja;
	}

	public void setIdReprezentacja(int idReprezentacja) {
		this.idReprezentacja = idReprezentacja;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public byte getWTurnieju() {
		return this.wTurnieju;
	}

	public void setWTurnieju(byte wTurnieju) {
		this.wTurnieju = wTurnieju;
	}

	public List<Mecz> getMeczs1() {
		return this.meczs1;
	}

	public void setMeczs1(List<Mecz> meczs1) {
		this.meczs1 = meczs1;
	}

	public Mecz addMeczs1(Mecz meczs1) {
		getMeczs1().add(meczs1);
		meczs1.setReprezentacja1(this);

		return meczs1;
	}

	public Mecz removeMeczs1(Mecz meczs1) {
		getMeczs1().remove(meczs1);
		meczs1.setReprezentacja1(null);

		return meczs1;
	}

	public List<Mecz> getMeczs2() {
		return this.meczs2;
	}

	public void setMeczs2(List<Mecz> meczs2) {
		this.meczs2 = meczs2;
	}

	public Mecz addMeczs2(Mecz meczs2) {
		getMeczs2().add(meczs2);
		meczs2.setReprezentacja2(this);

		return meczs2;
	}

	public Mecz removeMeczs2(Mecz meczs2) {
		getMeczs2().remove(meczs2);
		meczs2.setReprezentacja2(null);

		return meczs2;
	}

	public List<Uzytkownik> getUzytkowniks() {
		return this.uzytkowniks;
	}

	public void setUzytkowniks(List<Uzytkownik> uzytkowniks) {
		this.uzytkowniks = uzytkowniks;
	}

	public Uzytkownik addUzytkownik(Uzytkownik uzytkownik) {
		getUzytkowniks().add(uzytkownik);
		uzytkownik.setReprezentacja(this);

		return uzytkownik;
	}

	public Uzytkownik removeUzytkownik(Uzytkownik uzytkownik) {
		getUzytkowniks().remove(uzytkownik);
		uzytkownik.setReprezentacja(null);

		return uzytkownik;
	}

}