package br.com.myapp.model;

import java.util.Date;

public class CategoriaProblema {

	
	private long idCategoria;
	private String categoria;
	private Date dataCriacao;
	private Funcionario criador;
	private Date dataAtualizacao;
	private Funcionario atualizador;
	private boolean ativo;
	
	
	// getters e setters:
	
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Funcionario getCriador() {
		return criador;
	}
	public void setCriador(Funcionario criador) {
		this.criador = criador;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public Funcionario getAtualizador() {
		return atualizador;
	}
	public void setAtualizador(Funcionario atualizador) {
		this.atualizador = atualizador;
	}
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
