package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "CATEGORIA_PROBLEMA")
public class CategoriaProblema implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_categoria_problema")
	@SequenceGenerator(name = "sq_categoria_problema", sequenceName = "sq_categoria_problema", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

	// --------------------------------------------------------

	@Column(name = "NOME")
	private String nome;

	@Column(name = "USUARIO_CRIADOR")
	private String usuarioCriador;

	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "USUARIO_ATUALIZADOR")
	private String usuarioAtualizador;

	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;

	@Column(name = "ATIVO")
	private boolean ativo;

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
		final CategoriaProblema other = (CategoriaProblema) obj;
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

		return "CategoriaProblema [id=" + this.id
				+ ", nome=" + this.nome
				+ ", usuarioCriador=" + this.usuarioCriador
				+ ", dataCriacao=" + this.dataCriacao
				+ ", usuarioAtualizador=" + this.usuarioAtualizador
				+ ", dataAtualizacao=" + this.dataAtualizacao
				+ ", ativo=" + this.ativo
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

	public String getUsuarioCriador() {

		return this.usuarioCriador;
	}

	public void setUsuarioCriador(final String usuarioCriador) {

		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataCriacao() {

		return this.dataCriacao;
	}

	public void setDataCriacao(final Date dataCriacao) {

		this.dataCriacao = dataCriacao;
	}

	public String getUsuarioAtualizador() {

		return this.usuarioAtualizador;
	}

	public void setUsuarioAtualizador(final String usuarioAtualizador) {

		this.usuarioAtualizador = usuarioAtualizador;
	}

	public Date getDataAtualizacao() {

		return this.dataAtualizacao;
	}

	public void setDataAtualizacao(final Date dataAtualizacao) {

		this.dataAtualizacao = dataAtualizacao;
	}

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}
	
	@Transient
	private String imagemStatus="../resources/images/off.png"; //Variável para exibição da imagem do Status considerado "false".
	
	public String getImagemStatus() {
		if(this.ativo==true){
			this.imagemStatus="../resources/images/on.png";
		}
		return imagemStatus;
	}

	public void setImagemStatus(String imagemStatus) {
		this.imagemStatus = imagemStatus;
	}

}
