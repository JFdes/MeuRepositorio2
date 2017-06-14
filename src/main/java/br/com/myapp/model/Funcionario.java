package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_funcionario")
	@SequenceGenerator(name = "sq_funcionario", sequenceName = "sq_funcionario", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "USUARIO")
	private String usuario;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "RG")
	private String rg;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@Column(name = "DATA_ADMISSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdmissao;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SETOR")
	private Setor setor;

	@Column(name = "ATIVO")
	private boolean ativo;

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
		final Funcionario other = (Funcionario) obj;
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

		return "Funcionario [id=" + this.id
				+ ", nome=" + this.nome
				+ ", usuario=" + this.usuario
				+ ", senha=" + this.senha
				+ ", rg=" + this.rg
				+ ", cpf=" + this.cpf
				+ ", telefone=" + this.telefone
				+ ", email=" + this.email
				+ ", dataNascimento=" + this.dataNascimento
				+ ", dataAdmissao=" + this.dataAdmissao
				+ ", logradouro=" + this.logradouro
				+ ", numero=" + this.numero
				+ ", bairro=" + this.bairro
				+ ", complemento=" + this.complemento
				+ ", cidade=" + this.cidade
				+ ", uf=" + this.uf
				+ ", cep=" + this.cep
				+ ", setor=" + this.setor
				+ ", ativo=" + this.ativo
				+ "]";
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getUsuario() {

		return this.usuario;
	}

	public void setUsuario(final String usuario) {

		this.usuario = usuario;
	}

	public String getSenha() {

		return this.senha;
	}

	public void setSenha(final String senha) {

		this.senha = senha;
	}

	public String getRg() {

		return this.rg;
	}

	public void setRg(final String rg) {

		this.rg = rg;
	}

	public String getCpf() {

		return this.cpf;
	}

	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	public String getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public Date getDataAdmissao() {

		return this.dataAdmissao;
	}

	public void setDataAdmissao(final Date dataAdmissao) {

		this.dataAdmissao = dataAdmissao;
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

	public Setor getSetor() {

		return this.setor;
	}

	public void setSetor(final Setor setor) {

		this.setor = setor;
	}

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

}
