package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CategoriaProblema implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_categoriaProblema")
	@SequenceGenerator(name = "sq_categoriaProblema", sequenceName = "sq_categoriaProblema", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;
	
	//--------------------------------------------------------
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "CRIADOR")
	private Funcionario criador;
	
	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	@OneToOne
	@Column(name = "ATUALIZADOR")
	private Funcionario atualizador; //VERIFICAR
	
	@Column(name = "ATIVO")
	private boolean ativo;

	//-------------------------------------------------------
	
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
		CategoriaProblema other = (CategoriaProblema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaProblema [id=" + this.id 
				+ ", categoria=" + this.categoria 
				+ ", dataCriacao=" + this.dataCriacao
				+ ", criador=" + this.criador 
				+ ", dataAtualizacao=" + this.dataAtualizacao 
				+ ", atualizador=" + this.atualizador
				+ ", ativo=" + this.ativo 
				+ "]";
	}
	
	
	//--------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Funcionario getCriador() {
		return criador;
	}

	public void setCriador(Funcionario criador) {
		this.criador = criador;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Funcionario getAtualizador() {
		return atualizador;
	}

	public void setAtualizador(Funcionario atualizador) {
		this.atualizador = atualizador;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	//--------------------------------------------------------
	
	
	
	
}
