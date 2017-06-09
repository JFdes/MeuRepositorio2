package br.com.myapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "SETOR")
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_setor")
	@SequenceGenerator(name = "sq_setor", sequenceName = "sq_setor", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

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
	private boolean ativo; // VERIFICAR

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
		final Setor other = (Setor) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Transient
	private final String imagemStatus = "../resources/images/off.png"; // Variável para exibição da imagem do Status considerado
																		// "false".

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "RL_SETOR_CATEGORIA_PROBLEMA", joinColumns = {
			@JoinColumn(name = "SETOR_ID", nullable = false, updatable = false)
	}, inverseJoinColumns = {
			@JoinColumn(name = "CATEGORIA_PROBLEMA_ID", nullable = false, updatable = false)
	})
	private Collection<CategoriaProblema> categoriasProblema;

	@Override
	public String toString() {

		return "Setor [id=" + this.id
				+ ", nome=" + this.nome
				+ ", usuarioCriador=" + this.usuarioCriador
				+ ", dataCriacao=" + this.dataCriacao
				+ ", usuarioAtualizador=" + this.usuarioAtualizador
				+ ", dataAtualizacao=" + this.dataAtualizacao
				+ ", ativo=" + this.ativo
				+ ", imagemStatus=" + this.imagemStatus
				+ ", categoriasProblema=" + this.categoriasProblema
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

	public Collection<CategoriaProblema> getCategoriasProblema() {

		return this.categoriasProblema;
	}

	public void setCategoriasProblema(final Collection<CategoriaProblema> categoriasProblema) {

		this.categoriasProblema = categoriasProblema;
	}

	public String getImagemStatus() {

		return this.imagemStatus;
	}
}
