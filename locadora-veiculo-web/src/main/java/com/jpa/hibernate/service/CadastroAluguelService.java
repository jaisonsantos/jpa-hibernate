package com.jpa.hibernate.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpa.hibernate.dao.AluguelDAO;
import com.jpa.hibernate.model.Aluguel;
import com.jpa.hibernate.util.jpa.Transactional;

public class CadastroAluguelService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AluguelDAO aluguelDAO;

	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException {
		if (aluguel.getCarro() == null) {
			throw new NegocioException("Carro é obrigatório!");
		}

		this.aluguelDAO.salvar(aluguel);
	}
}
