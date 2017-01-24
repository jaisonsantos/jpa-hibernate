package com.jpa.hibernate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jpa.hibernate.dao.AcessorioDAO;
import com.jpa.hibernate.model.Acessorio;
import com.jpa.hibernate.util.cdi.CDIServiceLocator;

@FacesConverter("acessorioConverter")
public class AcessorioConverter implements Converter {

	private AcessorioDAO acessorioDAO;

	public AcessorioConverter() {
		this.acessorioDAO = CDIServiceLocator.getBean(AcessorioDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Acessorio retorno = null;
		if (value != null) {
			retorno = this.acessorioDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Acessorio) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
	
	
}
