package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@SequenceGenerator(name = "sq_cliente", sequenceName = "sq_cliente", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "CRIADOR")
	private Funcionario criador;
	
	@OneToOne
	@JoinColumn(name = "ATUALIZADOR")
	private Funcionario atualizador;
	
	@Column(name = "DATA_DESCRICAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "DATA_DESCRICAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;
	
	@Column(name = "INSCEST")
	private String inscest;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "REGIME_TRIBUTARIO")
	private String RegimeTributario;
	
	@OneToMany
	@JoinColumn(name="CATEGORIA_CLIENTE")
	private CategoriaCliente categoriaCliente; //relacionamento com CategoriaCliente. VERIFICAR!!!
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "UF")
	private String uf;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "PONTO_REFERENCIA")
	private String pontoReferencia;
	
	@Column(name = "FONE1")
	private String fone1;
	
	@Column(name = "FONE2")
	private String fone2;
	
	@Column(name = "WHATSAPP")
	private String whatsapp;
	
	@Column(name = "PROPRIETARIO")
	private String proprietario;
	
	@Column(name = "FONE_PROPRIETARIO")
	private String foneProprietario;
	
	@Column(name = "WHATSAPP_PROPRIETARIO")
	private String whatsappProprietario;
	
	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Column(name = "NOME_CONTATO")
	private String nomeContato;
	
	@Column(name = "FONE_CONTATO")
	private String foneContato;	
	
	@Column(name = "OBS")
	private String obs;
	
	@Column(name = "ATIVO") //verificar se tem algo a mais.
	private boolean ativo;

	
	//---------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//-----------------------------------------------------------------

	@Override
	public String toString() {
		return "Cliente [id=" + this.id 
				+ ", criador=" + this.criador 
				+ ", atualizador=" + this.atualizador 
				+ ", dataCriacao=" + this.dataCriacao 
				+ ", dataAtualizacao=" + this.dataAtualizacao 
				+ ", nomeFantasia=" + this.nomeFantasia 
				+ ", cnpj=" + this.cnpj 
				+ ", razaoSocial=" + this.razaoSocial 
				+ ", inscest=" + this.inscest 
				+ ", email=" + this.email
				+ ", RegimeTributario=" + this.RegimeTributario 
				+ ", categoriaCliente=" + this.categoriaCliente 
				+ ", logradouro=" + this.logradouro 
				+ ", numero=" + this.numero 
				+ ", bairro=" + this.bairro 
				+ ", complemento=" + this.complemento
				+ ", cidade=" + this.cidade 
				+ ", uf=" + this.uf 
				+ ", cep=" + this.cep 
				+ ", pontoReferencia=" + this.pontoReferencia
				+ ", fone1=" + this.fone1 
				+ ", fone2=" + this.fone2 
				+ ", whatsapp=" + this.whatsapp 
				+ ", proprietario=" + this.proprietario
				+ ", foneProprietario=" + this.foneProprietario 
				+ ", whatsappProprietario=" + this.whatsappProprietario
				+ ", dataNascimento=" + this.dataNascimento 
				+ ", nomeContato=" + this.nomeContato 
				+ ", foneContato=" + this.foneContato
				+ ", obs=" + this.obs 
				+ ", ativo=" + this.ativo 
				+ "]";
	}
	
	//-------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	//------------------------------------------------
	
	
	
	
	
}
