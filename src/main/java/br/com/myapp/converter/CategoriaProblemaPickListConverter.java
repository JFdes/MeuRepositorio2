package br.com.myapp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import br.com.myapp.model.CategoriaProblema;

@FacesConverter(value = "categoriaProblemaPickListConverter")
public class CategoriaProblemaPickListConverter implements Converter {

	@SuppressWarnings("unchecked")
	@Override
	public Object getAsObject(final FacesContext facesContext, final UIComponent uiComponent, final String id) {

		if (id != null && !id.isEmpty()) {

			final DualListModel<CategoriaProblema> categorias =
					(DualListModel<CategoriaProblema>) ((PickList) uiComponent).getValue();

			for (final CategoriaProblema categoria : categorias.getSource()) {

				if (StringUtils.isNotBlank(id) && Long.valueOf(id).equals(categoria.getId())) {
					return categoria;
				}
			}

			for (final CategoriaProblema categoria : categorias.getTarget()) {

				if (StringUtils.isNotBlank(id) && Long.valueOf(id).equals(categoria.getId())) {
					return categoria;
				}
			}

		}

		return null;
	}

	@Override
	public String getAsString(final FacesContext facesContext, final UIComponent uiComponent, final Object value) {

		if (value instanceof CategoriaProblema) {

			final CategoriaProblema entity = (CategoriaProblema) value;

			if (entity != null && entity instanceof CategoriaProblema && entity.getId() != null) {

				uiComponent.getAttributes().put(entity.getId().toString(), entity);
				return entity.getId().toString();
			}
		}

		return "";
	}

}
