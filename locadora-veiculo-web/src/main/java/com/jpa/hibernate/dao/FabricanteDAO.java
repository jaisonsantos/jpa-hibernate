package com.jpa.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jpa.hibernate.model.Fabricante;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	public void salvar(Fabricante fabricante){
		em.merge(fabricante);
	}
	
	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {
		fabricante = em.find(Fabricante.class, fabricante.getCodigo());
		em.remove(fabricante);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante").getResultList();
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
	}
}
