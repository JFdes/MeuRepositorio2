package br.com.myapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "TELEFONE")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_telefone")
	@SequenceGenerator(name = "sq_telefone", sequenceName = "sq_telefone", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente idCliente;

	@Column(name = "DDD")
	private String ddd;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "TIPO")
	private String tipo;

	// ---------------------------------------------------

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
		final Telefone other = (Telefone) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	// --------------------------------------------------------

	@Override
	public String toString() {

		return "Telefone [id=" + this.id
				+ ", idCliente=" + this.idCliente
				+ ", ddd=" + this.ddd
				+ ", numero=" + this.numero
				+ ", tipo=" + this.tipo
				+ "]";
	}

	// --------------------------------------------------------

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public Cliente getIdCliente() {

		return this.idCliente;
	}

	public void setIdCliente(final Cliente idCliente) {

		this.idCliente = idCliente;
	}

	public String getDdd() {

		return this.ddd;
	}

	public void setDdd(final String ddd) {

		this.ddd = ddd;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getTipo() {

		return this.tipo;
	}

	public void setTipo(final String tipo) {

		this.tipo = tipo;
	}

	// --------------------------------------------------------

}
