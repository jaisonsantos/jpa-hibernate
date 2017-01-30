package com.jpa.hibernate.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jpa.hibernate.model.Motorista;
import com.jpa.hibernate.model.Sexo;
import com.jpa.hibernate.service.CadastroMotoristaService;
import com.jpa.hibernate.service.NegocioException;
import com.jpa.hibernate.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroMotoristaService cadastroMotoristaService; 
	private Motorista motorista;
	private List<Sexo> sexos;
	
	public void salvar(){
		try {
			this.cadastroMotoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}
	
	@PostConstruct
	public void init(){
		this.limpar();
		this.sexos = Arrays.asList(Sexo.values());
	}

	public void limpar() {
		this.motorista = new Motorista();
	}

	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	public List<Sexo> getSexos() {
		return sexos;
	}
}
