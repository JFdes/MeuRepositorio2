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

@Entity(name = "SETOR")
public class Setor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_setor")
	@SequenceGenerator(name = "sq_setor", sequenceName = "sq_setor", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;
	
	@Column(name = "NOME")
	private String nome;
		
	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	
	@Column(name="USUARIO_CRIADOR")
	private String usuarioCriador;
	
	@Column(name="USUARIO_ATUALIZADOR")
	private String usuarioAtualizador;
	
	@Column(name="ATIVO")
	private boolean ativo; //VERIFICAR

	
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	//--------------------------------------------

	@Override
	public String toString() {
		return "Setor [id=" + this.id 
				+ ", nome=" + this.nome 
				+ ", dataCriacao=" + this.dataCriacao 
				+ ", dataAtualizacao=" + this.dataAtualizacao 
				+ ", usuarioCriador=" + this.usuarioCriador 
				+ ", usuarioAtualizador=" + this.usuarioAtualizador 
				+ ", ativo=" + this.ativo 
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCriador() {
		return usuarioCriador;
	}

	public void setCriador(String usuarioCriado) {
		this.usuarioCriador = usuarioCriado;
	}

	public String getUsuarioAtualizador() {
		return usuarioAtualizador;
	}

	public void setAtualizador(String usuarioAtualizador) {
		this.usuarioAtualizador = usuarioAtualizador;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	//------------------------------------------------
	
	
	
	
	
	
}
