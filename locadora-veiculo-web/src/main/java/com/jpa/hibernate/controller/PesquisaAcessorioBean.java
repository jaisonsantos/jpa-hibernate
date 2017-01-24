package com.jpa.hibernate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.dao.AcessorioDAO;
import com.jpa.hibernate.model.Acessorio;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioDAO acessorioDAO;
	private List<Acessorio> acessorios = new ArrayList<>();
	private Acessorio acessorioSelecionado;
	
	@PostConstruct
	public void inicializar(){
		acessorios = acessorioDAO.buscarTodos();
	}

	public void excluir(){
		try {
			acessorioDAO.excluir(acessorioSelecionado);
			this.acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessório: " + acessorioSelecionado.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}

	public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}
	
}
