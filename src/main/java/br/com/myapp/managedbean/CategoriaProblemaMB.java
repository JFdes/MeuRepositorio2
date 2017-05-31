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
import br.com.myapp.model.CategoriaProblema;
import br.com.myapp.service.CategoriaProblemaService;

@ManagedBean
@ViewScoped
public class CategoriaProblemaMB {

	
	//---------------------------------------------------- Atributos da classe.
	private CategoriaProblema categoriaProblema = new CategoriaProblema();

	private List<CategoriaProblema> categoriaProblemas = new ArrayList<CategoriaProblema>();
	
	private String nomeCategoria;

	private String usuarioCriador;

	private String usuarioAtualizador;

	private Date dataCriacao;

	private Date dataAtualizacao;

	private boolean ativo;
	
	//-----------------------------------------------------

	@EJB
	private CategoriaProblemaService categoriaProblemaService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.categoriaProblema = this.categoriaProblemaService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	//----------------------------------------------------- Método salvar.
	public void salvar() {

		try {

			this.categoriaProblemaService.criar(this.categoriaProblema);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/listagem/consultaCategoriaProblema.xhtml"); // Redireciona para a wiew de listagem.
	}

	//----------------------------------------------------- Método editar (redireciona para a wiew de cadastro)
	public void editar() {

		this.doRedirect("/problemas/problema.xhtml?id=" + this.categoriaProblema.getId());
	}
	
	//----------------------------------------------------- Método remover.

	public void remover() {

		try {

			this.categoriaProblemaService.deletar(this.categoriaProblema);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}
	}
	
	//-----------------------------------------------------

	public void doRedirect(final String redirectPage) throws FacesException {

		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		try {
			externalContext.redirect(externalContext.getRequestContextPath().concat(redirectPage));
		} catch (final IOException e) {
			throw new FacesException(e);
		}
	}
	
	//-----------------------------------------------------

	public String getParam(final String param) {

		final FacesContext context = FacesContext.getCurrentInstance();
		final Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		final String projectId = paramMap.get(param);
		return projectId;
	}

	//-----------------------------------------------
	
	
	public CategoriaProblema getCategoriaProblema() {

		return this.categoriaProblema;
	}

	public void setCategoriaProblema(final CategoriaProblema categoriaProblema) {

		this.categoriaProblema = categoriaProblema;
	}

	
	//----------------------------------------------- (get e set da lista) carrega a lista para o redirecionamento da View.
	
	public List<CategoriaProblema> getCategoriaProblemas() throws BusinessException { 

		this.categoriaProblemas = (List<CategoriaProblema>) this.categoriaProblemaService.buscarTodos();
		return this.categoriaProblemas;
	}

	public void setCategoriaProblemas(final List<CategoriaProblema> categoriaProblemas) {

		this.categoriaProblemas = categoriaProblemas;
	}
	
	//-----------------------------------------------------

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
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

	public CategoriaProblemaService getCategoriaProblemaService() {
		return categoriaProblemaService;
	}

	public void setCategoriaProblemaService(CategoriaProblemaService categoriaProblemaService) {
		this.categoriaProblemaService = categoriaProblemaService;
	}
	
}