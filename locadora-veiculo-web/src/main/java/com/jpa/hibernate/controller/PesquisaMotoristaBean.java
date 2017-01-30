package com.jpa.hibernate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.dao.MotoristaDAO;
import com.jpa.hibernate.model.Motorista;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private MotoristaDAO motoristaDAO;
	private List<Motorista> motoristas = new ArrayList<>();
	private Motorista motoristaSelecionado;
	
	@PostConstruct
	public void inicializar(){
		motoristas = motoristaDAO.buscarTodos();
	}

	public void excluir(){
		try {
			motoristaDAO.excluir(motoristaSelecionado);
			this.motoristas.remove(motoristaSelecionado);
			FacesUtil.addSuccessMessage("Motorista: " + motoristaSelecionado.getNome() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}

	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

}
