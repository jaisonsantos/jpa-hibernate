package com.jpa.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jpa.hibernate.model.ModeloCarro;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	public void salvar(ModeloCarro modeloCarro) {
		em.merge(modeloCarro);
	}
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return em.find(ModeloCarro.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return em.createQuery("from ModeloCarro").getResultList();
	}
	
	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException {
		modeloCarro = buscarPeloCodigo(modeloCarro.getCodigo());
		try {
			em.remove(modeloCarro);
			em.flush();
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}
}
