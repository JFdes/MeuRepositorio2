package br.com.myapp.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Setor;
import br.com.myapp.service.SetorService;

@ManagedBean
@ViewScoped
public class SetorMB {

	// -------------------------------------------------

	private Setor setor = new Setor();

	private List<Setor> setores = new ArrayList<Setor>();

	// -------------------------------------------------

	private String nome;

	private Date dataCriacao;

	private Date dataAtualizacao;

	private String usuarioCriador;

	private String usuarioAtualizador;

	private boolean ativo;

	// ---------------------------------------------------
	@EJB
	private SetorService setorService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.setor = this.setorService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	// -----------------------------------------------------

	public void salvar() {

		try {
			final Date data = new Date();

			if (this.setor.getId() == null) {
				this.setor.setDataCriacao(data);
				this.setor.setAtivo(true);
			} else {
				this.setor.setDataAtualizacao(data);
			}

			this.setorService.criar(this.setor);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/listagem/consultaSetor.xhtml");
	}

	// -------------------------------------------------

	public void editar() {

		this.doRedirect("/funcionarios/setor.xhtml?id=" + this.setor.getId());
	}

	// -------------------------------------------------

	public void remover() {

		try {

			this.setorService.deletar(this.setor);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}
	}

	// -------------------------------------------------

	public void doRedirect(final String redirectPage) throws FacesException {

		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		try {
			externalContext.redirect(externalContext.getRequestContextPath().concat(redirectPage));
		} catch (final IOException e) {
			throw new FacesException(e);
		}
	}

	// -------------------------------------------------

	public String getParam(final String param) {

		final FacesContext context = FacesContext.getCurrentInstance();
		final Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		final String projectId = paramMap.get(param);
		return projectId;
	}

	// -------------------------------------------------

	public Setor getSetor() {

		return this.setor;
	}

	public void setSetor(final Setor setor) {

		this.setor = setor;
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public Date getDataCriacao() {

		return this.dataCriacao;
	}

	public void setDataCriacao(final Date dataCriacao) {

		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {

		return this.dataAtualizacao;
	}

	public void setDataAtualizacao(final Date dataAtualizacao) {

		this.dataAtualizacao = dataAtualizacao;
	}

	public String getUsuarioCriador() {

		return this.usuarioCriador;
	}

	public void setUsuarioCriador(final String usuarioCriador) {

		this.usuarioCriador = usuarioCriador;
	}

	public String getUsuarioAtualizador() {

		return this.usuarioAtualizador;
	}

	public void setUsuarioAtualizador(final String usuarioAtualizador) {

		this.usuarioAtualizador = usuarioAtualizador;
	}

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

	// -------------------------------------------------

	public SetorService getSetorService() {

		return this.setorService;
	}

	public void setSetorService(final SetorService setorService) {

		this.setorService = setorService;
	}

	// ----------------------------------------------- carrega a lista para o redirecionamento da View.

	public List<Setor> getSetores() throws BusinessException {

		this.setores = (List<Setor>) this.setorService.buscarTodos();
		return this.setores;
	}

	public void setSetores(final List<Setor> setores) {

		this.setores = setores;
	}

	// --------------------------------------------------

}