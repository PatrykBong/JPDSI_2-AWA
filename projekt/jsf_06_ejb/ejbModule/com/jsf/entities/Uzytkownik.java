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
 * The persistent class for the uzytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="Uzytkownik.findAll", query="SELECT u FROM Uzytkownik u")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_uzytkownik")
	private int idUzytkownik;

	private String haslo;

	private String imie;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="kiedy_zmodyfikowal")
	private Date kiedyZmodyfikowal;

	private String nazwisko;

	private String nick;

	private int punkty;

	private String rola;

	//bi-directional many-to-one association to Typ
	@OneToMany(mappedBy="uzytkownikBean")
	private List<Typ> typs;

	//bi-directional many-to-one association to Reprezentacja
	@ManyToOne
	@JoinColumn(name="typ_na_mistrza")
	private Reprezentacja reprezentacja;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	@JoinColumn(name="kto_zmodyfikowal")
	private Uzytkownik uzytkownik;

	//bi-directional many-to-one association to Uzytkownik
	@OneToMany(mappedBy="uzytkownik")
	private List<Uzytkownik> uzytkowniks;

	public Uzytkownik() {
	}

	public int getIdUzytkownik() {
		return this.idUzytkownik;
	}

	public void setIdUzytkownik(int idUzytkownik) {
		this.idUzytkownik = idUzytkownik;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return this.imie;
	}
	
	public void setRola(String rola) {
		this.rola = rola;
	}

	public String getRola() {
		return this.rola;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getKiedyZmodyfikowal() {
		return this.kiedyZmodyfikowal;
	}

	public void setKiedyZmodyfikowal(Date kiedyZmodyfikowal) {
		this.kiedyZmodyfikowal = kiedyZmodyfikowal;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPunkty() {
		return this.punkty;
	}

	public void setPunkty(int punkty) {
		this.punkty = punkty;
	}

	public List<Typ> getTyps() {
		return this.typs;
	}

	public void setTyps(List<Typ> typs) {
		this.typs = typs;
	}

	public Typ addTyp(Typ typ) {
		getTyps().add(typ);
		typ.setUzytkownikBean(this);

		return typ;
	}

	public Typ removeTyp(Typ typ) {
		getTyps().remove(typ);
		typ.setUzytkownikBean(null);

		return typ;
	}

	public Reprezentacja getReprezentacja() {
		return this.reprezentacja;
	}

	public void setReprezentacja(Reprezentacja reprezentacja) {
		this.reprezentacja = reprezentacja;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public List<Uzytkownik> getUzytkowniks() {
		return this.uzytkowniks;
	}

	public void setUzytkowniks(List<Uzytkownik> uzytkowniks) {
		this.uzytkowniks = uzytkowniks;
	}

	public Uzytkownik addUzytkownik(Uzytkownik uzytkownik) {
		getUzytkowniks().add(uzytkownik);
		uzytkownik.setUzytkownik(this);

		return uzytkownik;
	}

	public Uzytkownik removeUzytkownik(Uzytkownik uzytkownik) {
		getUzytkowniks().remove(uzytkownik);
		uzytkownik.setUzytkownik(null);

		return uzytkownik;
	}

}