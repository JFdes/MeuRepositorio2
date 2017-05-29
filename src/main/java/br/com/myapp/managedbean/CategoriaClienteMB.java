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
import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Sexo;
import br.com.myapp.service.CategoriaClienteService;

@ManagedBean
@ViewScoped
public class CategoriaClienteMB {

	private String categoria;
	
	private String usuarioCriador;
	
	private String usuarioAtualizador;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;

	private boolean ativo;

	private CategoriaCliente categoriaCliente = new CategoriaCliente();

	private List<CategoriaCliente> categoriaClientes = new ArrayList<CategoriaCliente>();

	//----------------------------------------------	
	@EJB
	private CategoriaClienteService categoriaClienteService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.categoriaCliente = this.categoriaClienteService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}
	
	//---------------------------------------------Método para salvar a Categoria:

	public void salvar() {

		try {

			this.categoriaClienteService.criar(this.categoriaCliente);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/listagem/consultaCategoriaCliente.xhtml");
	}
	
	//---------------------------------------------Método para editar a Categoria:

	public void editar() {

		this.doRedirect("/clientes/categoriaCliente.xhtml?id=" + this.categoriaCliente.getId());
	}
	
	

	public void remover() {

		try {

			this.categoriaClienteService.deletar(this.categoriaCliente);
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
	
	//----------------------------------------------	

	public String getParam(final String param) {

		final FacesContext context = FacesContext.getCurrentInstance();
		final Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		final String projectId = paramMap.get(param);
		return projectId;
	}

	
	
	
	public Collection<Sexo> getSexos() {

		return Arrays.asList(Sexo.values());
	}
	
	
	//----------------------------------------------

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public CategoriaCliente getCategoriaCliente() {
		return categoriaCliente;
	}

	public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
		this.categoriaCliente = categoriaCliente;
	}

	public List<CategoriaCliente> getCategoriaClientes() {
		return categoriaClientes;
	}

	public void setCategoriaClientes(List<CategoriaCliente> categoriaClientes) {
		this.categoriaClientes = categoriaClientes;
	}

	public CategoriaClienteService getCategoriaClienteService() {
		return categoriaClienteService;
	}

	public void setCategoriaClienteService(CategoriaClienteService categoriaClienteService) {
		this.categoriaClienteService = categoriaClienteService;
	}
	
	//----------------------------------------------
	
	



}