package br.com.myapp.model;

public enum Sexo {

	M("Masculino"),
	F("Feminino");

	private String value;

	private Sexo(final String value) {
		this.value = value;
	}

	public String getValue() {

		return this.value;
	}

}
