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


@Entity(name = "CICLO")
public class Ciclo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_ciclo")
	@SequenceGenerator(name = "sq_ciclo", sequenceName = "sq_ciclo", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "DATA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	@Column(name = "DATA_FIM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;
	
	
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
		Ciclo other = (Ciclo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ciclo [id=" + id 
				+ ", descricao=" + this.descricao 
				+ ", dataInicio=" + this.dataInicio 
				+ ", dataFim=" + this.dataFim
				+ ", usuarioCriador=" + usuarioCriador 
				+ ", usuarioAtualizador=" + usuarioAtualizador 
				+ ", dataCriacao=" + dataCriacao 
				+ ", dataAtualizacao=" + dataAtualizacao 
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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

		
	
}
