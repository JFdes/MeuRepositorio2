package br.com.myapp.model;

import java.util.Date;

public class Ciclo {


	private long idCiclo;
	private String descricao;
	private Date inicio;
	private Date fim;
	
	// Getters e Setters:
	
	public long getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(long idCiclo) {
		this.idCiclo = idCiclo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	
}
