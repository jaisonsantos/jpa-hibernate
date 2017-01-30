package com.jpa.hibernate.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpa.hibernate.dao.MotoristaDAO;
import com.jpa.hibernate.model.Motorista;
import com.jpa.hibernate.util.jpa.Transactional;

public class CadastroMotoristaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MotoristaDAO motoristaDAO;
	
	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		if (motorista.getSexo() == null) {
			throw new NegocioException("Sexo é obrigatório!");
		}
		
		this.motoristaDAO.salvar(motorista);
	}
}
