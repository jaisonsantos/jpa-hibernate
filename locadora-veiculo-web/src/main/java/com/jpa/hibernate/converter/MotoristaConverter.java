package com.jpa.hibernate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jpa.hibernate.dao.MotoristaDAO;
import com.jpa.hibernate.model.Motorista;
import com.jpa.hibernate.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Motorista.class)
public class MotoristaConverter implements Converter {

	private MotoristaDAO motoristaDAO;

	public MotoristaConverter() {
		this.motoristaDAO = CDIServiceLocator.getBean(MotoristaDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Motorista retorno = null;
		if (value != null) {
			retorno = this.motoristaDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Motorista) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
	
	
}
