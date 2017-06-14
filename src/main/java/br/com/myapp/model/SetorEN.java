package br.com.myapp.model;

import org.apache.commons.lang3.StringUtils;

public enum SetorEN {

	ATENDIMENTO,
	OUTROS;

	public static SetorEN get(final String value) {

		if (StringUtils.containsIgnoreCase(value, SetorEN.ATENDIMENTO.name())) {
			return SetorEN.ATENDIMENTO;
		}

		return SetorEN.OUTROS;
	}

}
