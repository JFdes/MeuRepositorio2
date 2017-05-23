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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Problema implements Serializable {

	private static final long serialVersionUID = 6650624143219863781L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_problema")
	@SequenceGenerator(name = "sq_problema", sequenceName = "sq_problema", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;
	
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente idCliente;
	

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DESCRICAO")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="ID_CICLO")
	private Ciclo idCiclo; // Relacionamento N:1

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private StatusProblema status;

	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "USUARIO_CRIADOR")
	private String usuarioCriador;

	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizaco;

	@Column(name = "USUARIO_ATUALIZADOR")
	private String usuarioAtualizador;


	
	//------------------------------------------------
	
	
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
		final Problema other = (Problema) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	//--------------------------------------------

	@Override
	public String toString() {

		return "Problema [id=" + this.id
				+ ", titulo=" + this.titulo
				+ ", descricao=" + this.descricao
				+ ", idCiclo=" + this.idCiclo
				+ ", status=" + this.status
				+ ", dataCriacao=" + this.dataCriacao
				+ ", usuarioCriador=" + this.usuarioCriador
				+ ", dataAtualizaco=" + this.dataAtualizaco
				+ ", usuarioAtualizador=" + this.usuarioAtualizador
				+ "]";
	}
	
	
	//-------------------------------------------------

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public String getTitulo() {

		return this.titulo;
	}

	public void setTitulo(final String titulo) {

		this.titulo = titulo;
	}

	public String getDescricao() {

		return this.descricao;
	}

	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}


	public Ciclo getIdCiclo() {

		return this.idCiclo;
	}

	public void setCiclo(final Ciclo idCiclo) {

		this.idCiclo = idCiclo;
	}

	public StatusProblema getStatus() {

		return this.status;
	}

	public void setStatus(final StatusProblema status) {

		this.status = status;
	}

	public Date getDataCriacao() {

		return this.dataCriacao;
	}

	public void setDataCriacao(final Date dataCriacao) {

		this.dataCriacao = dataCriacao;
	}

	public String getUsuarioCriador() {

		return this.usuarioCriador;
	}

	public void setUsuarioCriador(final String usuarioCriador) {

		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataAtualizaco() {

		return this.dataAtualizaco;
	}

	public void setDataAtualizaco(final Date dataAtualizaco) {

		this.dataAtualizaco = dataAtualizaco;
	}

	public String getUsuarioAtualizador() {

		return this.usuarioAtualizador;
	}

	public void setUsuarioAtualizador(final String usuarioAtualizador) {

		this.usuarioAtualizador = usuarioAtualizador;
	}

}
