package br.com.myapp.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import javax.persistence.Column;
import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Ciclo;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Problema;
import br.com.myapp.model.Sexo;
import br.com.myapp.model.StatusProblema;
import br.com.myapp.service.ProblemaService;

@ManagedBean
@ViewScoped
public class ProblemaMB {

private Cliente idCliente;
	

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DESCRICAO")
	private String descricao;
	
	private Ciclo idCiclo; // Relacionamento N:1

	private StatusProblema status;
	private Date dataCriacao;

	private String usuarioCriador;

	private Date dataAtualizaco;

	private String usuarioAtualizador;

	
	private Problema problema = new Problema();

	private List<Problema> problemas = new ArrayList<Problema>();

	@EJB
	private ProblemaService problemaService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.problema = this.problemaService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvar() {

		try {
			Date data = new Date();

			if(problema.id==null) {
				this.problema.setDataCriacao(data);
					
			}
			else
				this.problema.setDataAtualizaco(data);

			this.problemaService.criar(this.problema);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/index.xhtml");
	}

	public void editar() {

		this.doRedirect("/problemas/prblema.xhtml?id=" + this.problema.getId());
	}

	public void remover() {

		try {

			this.problemaService.deletar(this.problema);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}
	}

	public void doRedirect(final String redirectPage) throws FacesException {

		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		try {
			externalContext.redirect(externalContext.getRequestContextPath().concat(redirectPage));
		} catch (final IOException e) {
			throw new FacesException(e);
		}
	}

	public String getParam(final String param) {

		final FacesContext context = FacesContext.getCurrentInstance();
		final Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		final String projectId = paramMap.get(param);
		return projectId;
	}

	public Collection<Sexo> getSexos() {

		return Arrays.asList(Sexo.values());
	}

	
	public Problema getProblema() {

		return this.problema;
	}

	public void setProblema(final Problema problema) {

		this.problema = problema;
	}

	
	//----------------------------------------------- carrega a lista para o redirecionamento da View.
	
	public List<Problema> getProblemas() throws BusinessException { 

		this.problemas = (List<Problema>) this.problemaService.buscarTodos();
		return this.problemas;
	}

	public void setIntegrantes(final List<Problema> problemas) {

		this.problemas = problemas;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ciclo getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Ciclo idCiclo) {
		this.idCiclo = idCiclo;
	}

	public StatusProblema getStatus() {
		return status;
	}

	public void setStatus(StatusProblema status) {
		this.status = status;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(String usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Date getDataAtualizaco() {
		return dataAtualizaco;
	}

	public void setDataAtualizaco(Date dataAtualizaco) {
		this.dataAtualizaco = dataAtualizaco;
	}

	public String getUsuarioAtualizador() {
		return usuarioAtualizador;
	}

	public void setUsuarioAtualizador(String usuarioAtualizador) {
		this.usuarioAtualizador = usuarioAtualizador;
	}

	public ProblemaService getProblemaService() {
		return problemaService;
	}

	public void setProblemaService(ProblemaService problemaService) {
		this.problemaService = problemaService;
	}

	public void setProblemas(List<Problema> problemas) {
		this.problemas = problemas;
	}
	
	

}