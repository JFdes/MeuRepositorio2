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
import br.com.myapp.model.Ciclo;
import br.com.myapp.service.CicloService;

@ManagedBean
@ViewScoped
public class CicloMB {
	
	private String descricao;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private String usuarioCriador;
	
	private String usuarioAtualizador;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;

		
	
	//-----------------------------------------------------

	private Ciclo ciclo = new Ciclo();

	private List<Ciclo> ciclos = new ArrayList<Ciclo>();

	@EJB
	private CicloService cicloService;

	
	//------------------------------------------------
	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.ciclo = this.cicloService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}
	
	//------------------------------------------------

	public void salvar() {

		try {
			Date data = new Date();

			if(ciclo.id==null) {
				this.ciclo.setDataCriacao(data);
			}
			else
				this.ciclo.setDataAtualizacao(data);

			this.cicloService.criar(this.ciclo);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/listagem/consultaCiclo.xhtml");
	}
	
	//------------------------------------------------

	public void editar() {

		this.doRedirect("/ciclos/ciclo.xhtml?id=" + this.ciclo.getId());
	}
	
	//------------------------------------------------

	public void remover() {

		try {

			this.cicloService.deletar(this.ciclo);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}
	}
	
	//-------------------------------------------------
	
	public void abrirCiclo(){ //abre o cliclo criado.
		Date data = new Date();
		this.ciclo.setDataInicio(data);
		this.doRedirect("/listagem/consultaCiclo.xhtml");
			
	}
	
	public void finalizarCiclo(){ //finaliza o clico aberto.
		
			Date data = new Date();

			if(ciclo.getDataInicio()!=null) {
				this.ciclo.setDataFim(data);
			}
			else
				abrirCiclo();
			
			this.doRedirect("/listagem/consultaCiclo.xhtml");
				
	}
	
	//------------------------------------------------

	public void doRedirect(final String redirectPage) throws FacesException {

		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		try {
			externalContext.redirect(externalContext.getRequestContextPath().concat(redirectPage));
		} catch (final IOException e) {
			throw new FacesException(e);
		}
	}
	
	//------------------------------------------------

	public String getParam(final String param) {

		final FacesContext context = FacesContext.getCurrentInstance();
		final Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		final String projectId = paramMap.get(param);
		return projectId;
	}


	//-------------------------------------------------
	
	public Ciclo getCiclo() {

		return this.ciclo;
	}

	public void setCiclo(final Ciclo ciclo) {

		this.ciclo = ciclo;
	}

	
	//----------------------------------------------- carrega a lista para o redirecionamento da View.
	
	public List<Ciclo> getCiclos() throws BusinessException { 

		this.ciclos = (List<Ciclo>) this.cicloService.buscarTodos();
		return this.ciclos;
	}

	public void setCiclos(final List<Ciclo> ciclos) {

		this.ciclos = ciclos;
	}
	
	//-------------------------------------------------

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

	
	public CicloService getCicloService() {
		return cicloService;
	}

	public void setCicloService(CicloService cicloService) {
		this.cicloService = cicloService;
	}
	
		

}