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
import br.com.myapp.model.Integrante;
import br.com.myapp.model.Sexo;
import br.com.myapp.service.IntegranteService;

@ManagedBean
@ViewScoped
public class IntegranteMB {

	private String nome;

	private String cpf;

	private String email;

	private Sexo sexo;

	private Date dataNascimento;

	private String logradouro;

	private String numero;

	private String uf;

	private String cidade;

	private String cep;

	private Integrante integrante = new Integrante();

	private List<Integrante> integrantes = new ArrayList<Integrante>();

	@EJB
	private IntegranteService integranteService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.integrante = this.integranteService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvar() {

		try {

			this.integranteService.criar(this.integrante);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/faltas/registro.xhtml");
	}

	public void editar() {

		this.doRedirect("/integrantes/cadastro.xhtml?id=" + this.integrante.getId());
	}

	public void remover() {

		try {

			this.integranteService.deletar(this.integrante);
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

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getCpf() {

		return this.cpf;
	}

	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public Sexo getSexo() {

		return this.sexo;
	}

	public void setSexo(final Sexo sexo) {

		this.sexo = sexo;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public String getLogradouro() {

		return this.logradouro;
	}

	public void setLogradouro(final String logradouro) {

		this.logradouro = logradouro;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getUf() {

		return this.uf;
	}

	public void setUf(final String uf) {

		this.uf = uf;
	}

	public String getCidade() {

		return this.cidade;
	}

	public void setCidade(final String cidade) {

		this.cidade = cidade;
	}

	public String getCep() {

		return this.cep;
	}

	public void setCep(final String cep) {

		this.cep = cep;
	}

	public Integrante getIntegrante() {

		return this.integrante;
	}

	public void setIntegrante(final Integrante integrante) {

		this.integrante = integrante;
	}

	public List<Integrante> getIntegrantes() throws BusinessException {

		this.integrantes = (List<Integrante>) this.integranteService.buscarTodos();
		return this.integrantes;
	}

	public void setIntegrantes(final List<Integrante> integrantes) {

		this.integrantes = integrantes;
	}

}