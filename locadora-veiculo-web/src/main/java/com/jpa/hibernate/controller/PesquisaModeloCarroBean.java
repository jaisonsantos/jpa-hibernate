package com.jpa.hibernate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.dao.ModeloCarroDAO;
import com.jpa.hibernate.model.ModeloCarro;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	private List<ModeloCarro> modelosCarro = new ArrayList<>();
	private ModeloCarro modeloCarroSelecionado;
	
	@PostConstruct
	public void inicializar(){
		modelosCarro = modeloCarroDAO.buscarTodos();
	}

	public void excluir(){
		try {
			modeloCarroDAO.excluir(modeloCarroSelecionado);
			this.modelosCarro.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo: " + modeloCarroSelecionado.getDescricao() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}

	public void setModeloCarroSelecionado(ModeloCarro modeloCarroSelecionado) {
		this.modeloCarroSelecionado = modeloCarroSelecionado;
	}

	public List<ModeloCarro> getModelosCarro() {
		return modelosCarro;
	}

	public void setModelosCarro(List<ModeloCarro> modelosCarro) {
		this.modelosCarro = modelosCarro;
	}
}
