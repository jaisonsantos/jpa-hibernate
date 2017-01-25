package com.jpa.hibernate.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jpa.hibernate.model.Aluguel;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(Aluguel aluguel) {
		em.merge(aluguel);
	}

}
