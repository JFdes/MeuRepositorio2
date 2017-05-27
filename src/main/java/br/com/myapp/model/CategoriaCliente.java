package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "CATEGORIA_CLIENTE")
public class CategoriaCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_categoriaCliente")
	@SequenceGenerator(name = "sq_categoriaCliente", sequenceName = "sq_categoriaCliente", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;

	@Column(name = "CATEGORIA")
	private String categoria;
		
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

	@Column(name = "ATIVO")
	private boolean ativo;

	
	//------------------------------------
	
	
	
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
				+ ", categoria=" + this.categoria 
				+ ", usuarioCriador=" + this.usuarioCriador
				+ ", usuarioAtualizador=" + this.usuarioAtualizador 
				+ ", dataCriacao=" + this.dataCriacao 
				+ ", dataAtualizacao=" + this.dataAtualizacao 
				+ ", ativo=" + this.ativo 
				+ "]";
	}

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

	public String getUsuarioCriador() {
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
