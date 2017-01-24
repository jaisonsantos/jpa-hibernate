package com.jpa.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jpa.hibernate.model.Carro;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public void salvar(Carro carro) {
		em.merge(carro);
	}
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = buscarPeloCodigo(carro.getCodigo());
		try {
			em.remove(carro);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro não pode ser excluído");
		}
	}
	
	public Carro buscarPeloCodigo(Long codigo) {
		return em.find(Carro.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos(){
		return em.createQuery("from Carro").getResultList();
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return em.createNamedQuery("Carro.buscarCarroComAcessorios", Carro.class)
				.setParameter("codigo", codigo).getSingleResult();
	}
	
}
