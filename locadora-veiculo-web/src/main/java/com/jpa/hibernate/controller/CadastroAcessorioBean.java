package com.jpa.hibernate.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.model.Acessorio;
import com.jpa.hibernate.service.CadastroAcessorioService;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Acessorio acessorio;
	@Inject
	private CadastroAcessorioService cadastroAcessorioService;

	public CadastroAcessorioBean() {
		this.limpar();
	}
	
	public void salvar() {
		try {
			this.cadastroAcessorioService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	private void limpar() {
		this.acessorio = new Acessorio();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

}
