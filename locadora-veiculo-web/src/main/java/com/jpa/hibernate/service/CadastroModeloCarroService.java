package com.jpa.hibernate.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpa.hibernate.dao.ModeloCarroDAO;
import com.jpa.hibernate.model.ModeloCarro;
import com.jpa.hibernate.util.jpa.Transactional;

public class CadastroModeloCarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	
	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {
		if (modeloCarro == null || modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("O nome do modelo do carro é obrigatório.");
		}
		
		if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("O fabricante é obrigatório.");
		}
		
		this.modeloCarroDAO.salvar(modeloCarro);
	}
	
}
