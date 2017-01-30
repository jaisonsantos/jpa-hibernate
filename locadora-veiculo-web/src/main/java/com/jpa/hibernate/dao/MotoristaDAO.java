package com.jpa.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jpa.hibernate.model.Motorista;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jpa.Transactional;

public class MotoristaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Motorista motorista) {
		em.merge(motorista);
	}
	
	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos() {
		return em.createQuery("from Motorista").getResultList();
	}
	
	public Motorista buscarPeloCodigo(Long codigo) {
		return em.find(Motorista.class, codigo);
	}
	
	@Transactional
	public void excluir(Motorista motorista) throws NegocioException {
		motorista = buscarPeloCodigo(motorista.getCodigo());
		try {
			em.remove(motorista);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Motorista não pode ser excluído.");
		}
	}
}
