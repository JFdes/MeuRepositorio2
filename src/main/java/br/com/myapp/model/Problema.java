package br.com.myapp.model;

import java.util.Date;

public class Problema {


	private long idProblema;
	private Cliente idCliente;
	private String titulo;
	private String descricao;
	private CategoriaProblema categoria;
	private Date dataCriacao;
	private String criador;
	private Date dataAtualizaco;
	private String atualizador;
	private StatusProblema status; //Relacionamento com a classe Status.
	
	//Getters e Setters:
	
	public long getIdProblema() {
		return idProblema;
	}
	public void setIdProblema(long idProblema) {
		this.idProblema = idProblema;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public CategoriaProblema getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProblema categoria) {
		this.categoria = categoria;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	}
	public Date getDataAtualizaco() {
		return dataAtualizaco;
	}
	public void setDataAtualizaco(Date dataAtualizaco) {
		this.dataAtualizaco = dataAtualizaco;
	}
	public String getAtualizador() {
		return atualizador;
	}
	public void setAtualizador(String atualizador) {
		this.atualizador = atualizador;
	}
	public StatusProblema getStatus() {
		return status;
	}
	public void setStatus(StatusProblema status) {
		this.status = status;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
