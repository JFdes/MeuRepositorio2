package br.com.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	public Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	private Cliente idCliente;
	
	
	@Column(name = "DDD")
	private String ddd;
	
	
	@Column(name = "NUMERO")
	private String numero;
	
	
	@Column(name = "TIPO")
	private String tipo;

	//---------------------------------------------------
	
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//--------------------------------------------------------

	@Override
	public String toString() {
		return "Telefone [id=" + this.id 
				+ ", idCliente=" + this.idCliente 
				+ ", ddd=" + this.ddd 
				+ ", numero=" + this.numero 
				+ ", tipo="	+ this.tipo 
				+ "]";
	}
	
	
	//--------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//--------------------------------------------------------
	
	
	
	
	
	
}
