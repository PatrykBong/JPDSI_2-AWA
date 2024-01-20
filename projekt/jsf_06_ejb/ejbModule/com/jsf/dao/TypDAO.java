package com.jsf.dao;

import java.util.List;
import java.util.Map;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jsf.entities.Typ;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class TypDAO {
	//private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext//(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Typ uzytk) {
		em.persist(uzytk);
	}

	public Typ merge(Typ uzytk) {
		return em.merge(uzytk);
	}

	public void remove(Typ uzytk) {
		em.remove(em.merge(uzytk));
	}

	public Typ find(Object id) {
		return em.find(Typ.class, id);
	}

	public List<Typ> getFullList() {
		List<Typ> list = null;

		Query query = em.createQuery("select p from Typ p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
