package com.jpa.hibernate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.dao.AcessorioDAO;
import com.jpa.hibernate.dao.ModeloCarroDAO;
import com.jpa.hibernate.model.Acessorio;
import com.jpa.hibernate.model.Carro;
import com.jpa.hibernate.model.ModeloCarro;
import com.jpa.hibernate.service.CadastroCarroService;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Carro carro;
	private List<ModeloCarro> modelosCarros;
	private List<Acessorio> acessorios;
	
	@Inject
	private CadastroCarroService cadastroCarroService;
	@Inject
	private AcessorioDAO acessorioDAO;
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		
		this.acessorios = this.acessorioDAO.buscarTodos();
		this.modelosCarros = this.modeloCarroDAO.buscarTodos();
	}

	public void salvar() {
		try {
			this.cadastroCarroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro desconhecido. Contactar o administrador");
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.carro = new Carro();
		this.carro.setAcessorios(new ArrayList<Acessorio>());
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

}
