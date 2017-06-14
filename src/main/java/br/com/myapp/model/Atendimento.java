package br.com.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = -3300236720062858143L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_atendimento")
	@SequenceGenerator(name = "sq_atendimento", sequenceName = "sq_atendimento", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

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
		final Atendimento other = (Atendimento) obj;
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

		return "Atendimento [id=" + this.id + "]";
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}
}
