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
 * The persistent class for the mecz database table.
 * 
 */
@Entity
@NamedQuery(name="Mecz.findAll", query="SELECT m FROM Mecz m")
public class Mecz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mecz")
	private int idMecz;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private String wynik;

	//bi-directional many-to-one association to Reprezentacja
	@ManyToOne
	@JoinColumn(name="druzyna_1")
	private Reprezentacja reprezentacja1;

	//bi-directional many-to-one association to Reprezentacja
	@ManyToOne
	@JoinColumn(name="druzyna_2")
	private Reprezentacja reprezentacja2;

	//bi-directional many-to-one association to Typ
	@OneToMany(mappedBy="meczBean")
	private List<Typ> typs;

	public Mecz() {
	}

	public int getIdMecz() {
		return this.idMecz;
	}

	public void setIdMecz(int idMecz) {
		this.idMecz = idMecz;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getWynik() {
		return this.wynik;
	}

	public void setWynik(String wynik) {
		this.wynik = wynik;
	}

	public Reprezentacja getReprezentacja1() {
		return this.reprezentacja1;
	}

	public void setReprezentacja1(Reprezentacja reprezentacja1) {
		this.reprezentacja1 = reprezentacja1;
	}

	public Reprezentacja getReprezentacja2() {
		return this.reprezentacja2;
	}

	public void setReprezentacja2(Reprezentacja reprezentacja2) {
		this.reprezentacja2 = reprezentacja2;
	}

	public List<Typ> getTyps() {
		return this.typs;
	}

	public void setTyps(List<Typ> typs) {
		this.typs = typs;
	}

	public Typ addTyp(Typ typ) {
		getTyps().add(typ);
		typ.setMeczBean(this);

		return typ;
	}

	public Typ removeTyp(Typ typ) {
		getTyps().remove(typ);
		typ.setMeczBean(null);

		return typ;
	}

}