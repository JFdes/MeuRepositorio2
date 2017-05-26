package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@SequenceGenerator(name = "sq_cliente", sequenceName = "sq_cliente", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;
	
	
	@Column(name = "USUARIO_CRIADOR")
	private String usuarioCriador;
	
	@Column(name = "USUARIO_ATUALIZADOR")
	private String usuarioAtualizador;
	
	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "DATA_ATUALIZACAO")
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
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA_CLIENTE")
	private CategoriaCliente idCategoriaCliente;
	
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
	
	@Column(name = "PROPRIETARIO")
	private String proprietario;
		
	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Column(name = "ATIVO")
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
				+ ", usuarioCriador=" + this.usuarioCriador 
				+ ", usuarioAtualizador=" + this.usuarioAtualizador 
				+ ", dataCriacao=" + this.dataCriacao 
				+ ", dataAtualizacao=" + this.dataAtualizacao 
				+ ", nomeFantasia=" + this.nomeFantasia 
				+ ", cnpj=" + this.cnpj 
				+ ", razaoSocial=" + this.razaoSocial 
				+ ", inscest=" + this.inscest 
				+ ", email=" + this.email
				+ ", RegimeTributario=" + this.RegimeTributario 
				+ ", idCategoriaCliente=" + this.idCategoriaCliente 
				+ ", logradouro=" + this.logradouro 
				+ ", numero=" + this.numero 
				+ ", bairro=" + this.bairro 
				+ ", complemento=" + this.complemento
				+ ", cidade=" + this.cidade 
				+ ", uf=" + this.uf 
				+ ", cep=" + this.cep 
				+ ", pontoReferencia=" + this.pontoReferencia
				+ ", proprietario=" + this.proprietario
				+ ", dataNascimento=" + this.dataNascimento 
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

	public String getCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(String usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public String getUsuarioAtualizador() {
		return usuarioAtualizador;
	}

	public void setUsuarioAtualizador(String usuarioAtualizador) {
		this.usuarioAtualizador = usuarioAtualizador;
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

	public CategoriaCliente getIdCategoriaCliente() {
		return idCategoriaCliente;
	}

	public void setIdcategoriaCliente(CategoriaCliente idCategoriaCliente) {
		this.idCategoriaCliente = idCategoriaCliente;
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

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	//------------------------------------------------
	
	
	
	
	
}
