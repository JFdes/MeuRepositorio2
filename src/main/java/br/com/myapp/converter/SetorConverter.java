package br.com.myapp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.myapp.model.Setor;

@FacesConverter(forClass = Setor.class)
public class SetorConverter implements Converter {

	@Override
	public Object getAsObject(final FacesContext facesContext, final UIComponent uiComponent, final String value) {

		if (value != null && !value.isEmpty()) {

			return uiComponent.getAttributes().get(value);
		}

		return null;
	}

	@Override
	public String getAsString(final FacesContext facesContext, final UIComponent uiComponent, final Object value) {

		if (value instanceof Setor) {

			final Setor entity = (Setor) value;

			if (entity != null && entity instanceof Setor && entity.getId() != null) {

				uiComponent.getAttributes().put(entity.getId().toString(), entity);
				return entity.getId().toString();
			}
		}

		return "";
	}
}
