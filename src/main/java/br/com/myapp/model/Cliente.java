package br.com.myapp.model;

import java.util.Date;

public class Cliente {


	private long idCliente;
	private Funcionario criador;
	private Funcionario atualizador;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private String nomeFantasia;
	private String cnpj;
	private String razaoSocial;
	private String inscest;
	private String email;
	private String RegimeTributario;
	private CategoriaCliente categoriaCliente; //relacionamento com CategoriaCliente.
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String cidade;
	private String uf;
	private String cep;
	private String pontoReferencia;
	private String fone1;
	private String fone2;
	private String whatsapp;
	private String proprietario;
	private String foneProprietario;
	private String whatsappProprietario;
	private Date dataNascimento;
	private String nomeContato;
	private String foneContato;	
	private String obs;
	private boolean ativo;
	
	//Getters e Setters:
	
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public Funcionario getCriador() {
		return criador;
	}
	public void setCriador(Funcionario criador) {
		this.criador = criador;
	}
	public Funcionario getAtualizador() {
		return atualizador;
	}
	public void setAtualizador(Funcionario atualizador) {
		this.atualizador = atualizador;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getInscest() {
		return inscest;
	}
	public void setInscest(String inscest) {
		this.inscest = inscest;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegimeTributario() {
		return RegimeTributario;
	}
	public void setRegimeTributario(String regimeTributario) {
		RegimeTributario = regimeTributario;
	}
	public CategoriaCliente getCategoriaCliente() {
		return categoriaCliente;
	}
	public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
		this.categoriaCliente = categoriaCliente;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	public String getFone1() {
		return fone1;
	}
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getFoneProprietario() {
		return foneProprietario;
	}
	public void setFoneProprietario(String foneProprietario) {
		this.foneProprietario = foneProprietario;
	}
	public String getWhatsappProprietario() {
		return whatsappProprietario;
	}
	public void setWhatsappProprietario(String whatsappProprietario) {
		this.whatsappProprietario = whatsappProprietario;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	public String getFoneContato() {
		return foneContato;
	}
	public void setFoneContato(String foneContato) {
		this.foneContato = foneContato;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
