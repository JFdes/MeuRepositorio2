package br.com.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class CategoriaCliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_categoriaCliente")
	@SequenceGenerator(name = "sq_categoriaCliente", sequenceName = "sq_categoriaCliente", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

	
		@Column(name = "CATEGORIA_CLIENTE")
		private String CategoriaCliente;
		
		
	    @Column(name="ATIVO") //verificar se está faltando algo.
	    private boolean ativo;


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
			CategoriaCliente other = (CategoriaCliente) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "CategoriaCliente [id=" + this.id 
					+ ", CategoriaCliente=" + this.CategoriaCliente 
					+ ", ativo=" + this.ativo
					+ "]";
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getCategoriaCliente() {
			return CategoriaCliente;
		}


		public void setCategoriaCliente(String categoriaCliente) {
			CategoriaCliente = categoriaCliente;
		}


		public boolean isAtivo() {
			return ativo;
		}


		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}
				
		
		
		
}
