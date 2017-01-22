package com.jpa.hibernate.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.model.Fabricante;
import com.jpa.hibernate.service.CadastroFabricanteService;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {
	
	@Inject
	private CadastroFabricanteService cadastroFabricanteService; 
	private Fabricante fabricante;
	
	public void salvar(){
		try {
			this.cadastroFabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init(){
		this.limpar();
	}

	private void limpar() {
		this.fabricante = new Fabricante();
	}

	public CadastroFabricanteService getCadastroFabricanteService() {
		return cadastroFabricanteService;
	}

	public void setCadastroFabricanteService(CadastroFabricanteService cadastroFabricanteService) {
		this.cadastroFabricanteService = cadastroFabricanteService;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
