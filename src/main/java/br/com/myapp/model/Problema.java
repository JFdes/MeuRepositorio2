package br.com.myapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "PROBLEMA")
public class Problema implements Serializable {

	private static final long serialVersionUID = 6650624143219863781L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_problema")
	@SequenceGenerator(name = "sq_problema", sequenceName = "sq_problema", allocationSize = 1)
	@Column(name = "ROW_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CICLO")
	private Ciclo ciclo; // Relacionamento N:1

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private StatusProblema status;

	@Column(name = "USUARIO_CRIADOR")
	private String usuarioCriador;

	@Column(name = "DATA_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@Column(name = "USUARIO_ATUALIZADOR")
	private String usuarioAtualizador;

	@Column(name = "DATA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizaco;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "RL_PROBLEMA_CATEGORIA_PROBLEMA", joinColumns = {
			@JoinColumn(name = "PROBLEMA_ID", nullable = false, updatable = false)
	}, inverseJoinColumns = {
			@JoinColumn(name = "CATEGORIA_PROBLEMA_ID", nullable = false, updatable = false)
	})
	private Collection<CategoriaProblema> categorias;

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

	@Override
	public String toString() {

		return "Problema [id=" + this.id
				+ ", cliente=" + this.cliente
				+ ", titulo=" + this.titulo
				+ ", descricao=" + this.descricao
				+ ", ciclo=" + this.ciclo
				+ ", status=" + this.status
				+ ", usuarioCriador=" + this.usuarioCriador
				+ ", dataCriacao=" + this.dataCriacao
				+ ", usuarioAtualizador=" + this.usuarioAtualizador
				+ ", dataAtualizaco=" + this.dataAtualizaco
				+ "]";
	}

	public Long getId() {

		return this.id;
	}

	public void setId(final Long id) {

		this.id = id;
	}

	public Cliente getCliente() {

		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {

		this.cliente = cliente;
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

	public Ciclo getCiclo() {

		return this.ciclo;
	}

	public void setCiclo(final Ciclo ciclo) {

		this.ciclo = ciclo;
	}

	public StatusProblema getStatus() {

		return this.status;
	}

	public void setStatus(final StatusProblema status) {

		this.status = status;
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

	public Date getDataAtualizaco() {

		return this.dataAtualizaco;
	}

	public void setDataAtualizaco(final Date dataAtualizaco) {

		this.dataAtualizaco = dataAtualizaco;
	}

	public Collection<CategoriaProblema> getCategorias() {

		return this.categorias;
	}

	public void setCategorias(final Collection<CategoriaProblema> categorias) {

		this.categorias = categorias;
	}
	
	//----------------------------------------
	
	@Transient
	private String imagemQuandroStatus = "../resources/images/branco.png";


	public String getImagemQuadroStatus() {
		if (this.status.equals("PENDENTE")){
			this.imagemQuandroStatus="../resources/images/vermelho.png";
			
			}
			else if (this.status.equals("RESOLVIDO")){
				this.imagemQuandroStatus="../resources/images/verde.png";
			
				}
		
		return this.imagemQuandroStatus;
	}
	
	//-----------------------------------------
	
	@Transient
	private String imagemQuadroRetorno = "../resources/images/branco.png";


	public String getImagemQuadroRetorno() {
		if (this.descricao.equals("")){
			this.imagemQuandroStatus="../resources/images/branco.png";
			
			}
		else 
			this.imagemQuandroStatus="../resources/images/amarelo.png";
			
				
		
		return this.imagemQuandroStatus;
	}
	
	//-------------------------------------------

}
