package com.jpa.hibernate.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpa.hibernate.dao.FabricanteDAO;
import com.jpa.hibernate.model.Fabricante;
import com.jpa.hibernate.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {

	@Inject
	FabricanteDAO fabricanteDAO;
	
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatório!");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}
}
