package br.com.myapp.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Sexo;
import br.com.myapp.model.Telefone;
import br.com.myapp.service.TelefoneService;

@ManagedBean
@ViewScoped
public class TelefoneMB {

	private Cliente idCliente;

	private String ddd;

	private String numero;

	private String tipo;

	private Telefone telefone = new Telefone();

	private List<Telefone> telefones = new ArrayList<Telefone>();

	@EJB
	private TelefoneService telefoneService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.telefone = this.telefoneService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvar() {

		try {

			this.telefoneService.criar(this.telefone);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

	}

	public void editar() {

		this.doRedirect("/telefones/cadastro.xhtml?id=" + this.telefone.getId());
	}

	public void remover() {

		try {

			this.telefoneService.deletar(this.telefone);
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

	public Telefone getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final Telefone telefone) {

		this.telefone = telefone;
	}

	public void setTelefones(final List<Telefone> telefones) {

		this.telefones = telefones;
	}

	public Cliente getIdCliente() {

		return this.idCliente;
	}

	public void setIdCliente(final Cliente idCliente) {

		this.idCliente = idCliente;
	}

	public String getDdd() {

		return this.ddd;
	}

	public void setDdd(final String ddd) {

		this.ddd = ddd;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getTipo() {

		return this.tipo;
	}

	public void setTipo(final String tipo) {

		this.tipo = tipo;
	}

	public TelefoneService getTelefoneService() {

		return this.telefoneService;
	}

	public void setTelefoneService(final TelefoneService telefoneService) {

		this.telefoneService = telefoneService;
	}

	// ----------------------------------------------- carrega a lista para o redirecionamento da View.

	public List<Telefone> getTelefones() throws BusinessException {

		this.telefones = (List<Telefone>) this.telefoneService.buscarTodos();
		return this.telefones;
	}

}