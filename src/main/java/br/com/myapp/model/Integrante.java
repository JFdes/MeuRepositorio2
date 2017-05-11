package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Integrante implements Serializable {

	private static final long serialVersionUID = 1303853532286010060L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_integrante")
	@SequenceGenerator(name = "sq_integrante", sequenceName = "sq_integrante", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SEXO")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@Column(name = "LOGRADOURO")
	private String logradouro;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "UF")
	private String uf;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "CEP")
	private String cep;

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
		final Integrante other = (Integrante) obj;
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

		return "Integrante [id=" + this.id
				+ ", nome=" + this.nome
				+ ", cpf=" + this.cpf
				+ ", email=" + this.email
				+ ", sexo=" + this.sexo
				+ ", dataNascimento=" + this.dataNascimento
				+ ", logradouro=" + this.logradouro
				+ ", numero=" + this.numero
				+ ", uf=" + this.uf
				+ ", cidade=" + this.cidade
				+ ", cep=" + this.cep
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

	public String getCpf() {

		return this.cpf;
	}

	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public Sexo getSexo() {

		return this.sexo;
	}

	public void setSexo(final Sexo sexo) {

		this.sexo = sexo;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
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

	public String getUf() {

		return this.uf;
	}

	public void setUf(final String uf) {

		this.uf = uf;
	}

	public String getCidade() {

		return this.cidade;
	}

	public void setCidade(final String cidade) {

		this.cidade = cidade;
	}

	public String getCep() {

		return this.cep;
	}

	public void setCep(final String cep) {

		this.cep = cep;
	}

}
