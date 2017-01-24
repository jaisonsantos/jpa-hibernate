package com.jpa.hibernate.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jpa.hibernate.dao.AcessorioDAO;
import com.jpa.hibernate.model.Acessorio;
import com.jpa.hibernate.util.jpa.Transactional;

public class CadastroAcessorioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioDAO acessorioDAO;
	
	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {
		if (acessorio == null || acessorio.getDescricao().trim().equals("")) {
			throw new NegocioException("Descrição do acessório é obrigatório");
		}
		
		this.acessorioDAO.salvar(acessorio);
	}
}
