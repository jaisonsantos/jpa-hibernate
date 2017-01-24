package com.jpa.hibernate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.jpa.hibernate.dao.ModeloCarroDAO;
import com.jpa.hibernate.model.ModeloCarro;
import com.jpa.hibernate.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ModeloCarro.class)
public class ModeloCarroConverter implements Converter {

	private ModeloCarroDAO modeloCarroDAO;

	public ModeloCarroConverter() {
		this.modeloCarroDAO = CDIServiceLocator.getBean(ModeloCarroDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		ModeloCarro retorno = null;
		if (value != null) {
			retorno = this.modeloCarroDAO.buscarPeloCodigo(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ModeloCarro) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}
	
	
}
