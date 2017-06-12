package br.com.myapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@SequenceGenerator(name = "sq_cliente", sequenceName = "sq_cliente", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

	@Column(name = "USUARIO_CRIADOR")
	private String usuarioCriador;

	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "USUARIO_ATUALIZADOR")
	private String usuarioAtualizador;

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
	private String regimeTributario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CATEGORIA_CLIENTE")
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

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cliente")
	private Collection<Telefone> telefones;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
	private Collection<Problema> problemas;

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Cliente other = (Cliente) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return "Cliente [id=" + this.id
				+ ", usuarioCriador=" + this.usuarioCriador
				+ ", dataCriacao=" + this.dataCriacao
				+ ", usuarioAtualizador=" + this.usuarioAtualizador
				+ ", dataAtualizacao=" + this.dataAtualizacao
				+ ", nomeFantasia=" + this.nomeFantasia
				+ ", cnpj=" + this.cnpj
				+ ", razaoSocial=" + this.razaoSocial
				+ ", inscest=" + this.inscest
				+ ", email=" + this.email
				+ ", regimeTributario=" + this.regimeTributario
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
				+ ", ativo=" + this.ativo + "]";
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getUsuarioCriador() {

		return this.usuarioCriador;
	}

	public void setUsuarioCriador(final String usuarioCriador) {

		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataCriacao() {

		return this.dataCriacao;
	}

	public void setDataCriacao(final Date dataCriacao) {

		this.dataCriacao = dataCriacao;
	}

	public String getUsuarioAtualizador() {

		return this.usuarioAtualizador;
	}

	public void setUsuarioAtualizador(final String usuarioAtualizador) {

		this.usuarioAtualizador = usuarioAtualizador;
	}

	public Date getDataAtualizacao() {

		return this.dataAtualizacao;
	}

	public void setDataAtualizacao(final Date dataAtualizacao) {

		this.dataAtualizacao = dataAtualizacao;
	}

	public String getNomeFantasia() {

		return this.nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {

		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {

		return this.cnpj;
	}

	public void setCnpj(final String cnpj) {

		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {

		return this.razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {

		this.razaoSocial = razaoSocial;
	}

	public String getInscest() {

		return this.inscest;
	}

	public void setInscest(final String inscest) {

		this.inscest = inscest;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public String getRegimeTributario() {

		return this.regimeTributario;
	}

	public void setRegimeTributario(final String regimeTributario) {

		this.regimeTributario = regimeTributario;
	}

	public CategoriaCliente getIdCategoriaCliente() {

		return this.idCategoriaCliente;
	}

	public void setIdCategoriaCliente(final CategoriaCliente idCategoriaCliente) {

		this.idCategoriaCliente = idCategoriaCliente;
	}

	public String getLogradouro() {

		return this.logradouro;
	}

	public void setLogradouro(final String logradouro) {

		this.logradouro = logradouro;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getBairro() {

		return this.bairro;
	}

	public void setBairro(final String bairro) {

		this.bairro = bairro;
	}

	public String getComplemento() {

		return this.complemento;
	}

	public void setComplemento(final String complemento) {

		this.complemento = complemento;
	}

	public String getCidade() {

		return this.cidade;
	}

	public void setCidade(final String cidade) {

		this.cidade = cidade;
	}

	public String getUf() {

		return this.uf;
	}

	public void setUf(final String uf) {

		this.uf = uf;
	}

	public String getCep() {

		return this.cep;
	}

	public void setCep(final String cep) {

		this.cep = cep;
	}

	public String getPontoReferencia() {

		return this.pontoReferencia;
	}

	public void setPontoReferencia(final String pontoReferencia) {

		this.pontoReferencia = pontoReferencia;
	}

	public String getProprietario() {

		return this.proprietario;
	}

	public void setProprietario(final String proprietario) {

		this.proprietario = proprietario;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

	public Collection<Telefone> getTelefones() {

		return this.telefones;
	}

	public void setTelefones(final Collection<Telefone> telefones) {

		this.telefones = telefones;
	}

	public Collection<Problema> getProblemas() {

		return this.problemas;
	}

	public void setProblemas(final Collection<Problema> problemas) {

		this.problemas = problemas;
	}

}
