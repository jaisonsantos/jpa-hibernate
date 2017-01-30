package com.jpa.hibernate.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.dao.FabricanteDAO;
import com.jpa.hibernate.model.Categoria;
import com.jpa.hibernate.model.Fabricante;
import com.jpa.hibernate.model.ModeloCarro;
import com.jpa.hibernate.service.CadastroModeloCarroService;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ModeloCarro modeloCarro;
	private List<Fabricante> fabricantes;
	private List<Categoria> categorias;
	
	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService; 

	@Inject
	private FabricanteDAO fabricanteDAO; 
	

	@PostConstruct
	public void inicializar(){
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias = Arrays.asList(Categoria.values());
	}

	public void salvar(){
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo carro salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	private void limpar() {
		this.modeloCarro = new ModeloCarro();
	}
	
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public CadastroModeloCarroService getCadastroModeloCarroService() {
		return cadastroModeloCarroService;
	}

	public void setCadastroModeloCarroService(CadastroModeloCarroService cadastroModeloCarroService) {
		this.cadastroModeloCarroService = cadastroModeloCarroService;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
}
