package com.jpa.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jpa.hibernate.model.Acessorio;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Acessorio acessorio) {
		em.merge(acessorio);
	}
	
	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarTodos() {
		return em.createQuery("from Acessorio").getResultList();
	}
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return em.find(Acessorio.class, codigo);
	}
	
	@Transactional
	public void excluir(Acessorio fabricante) throws NegocioException {
		fabricante = buscarPeloCodigo(fabricante.getCodigo());
		try {
			em.remove(fabricante);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Acessório não pode ser excluído.");
		}
	}
}
