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
import br.com.myapp.model.Funcionario;
import br.com.myapp.model.Setor;
import br.com.myapp.service.FuncionarioService;

@ManagedBean
@ViewScoped
public class FuncionarioMB {

	private Funcionario funcionario = new Funcionario();

	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	// --------------------------------------------

	private String nome;

	private String usuario;

	private String senha;

	private int rg;

	private int cpf;

	private String fone;

	private String email;

	private Date dtNascimento;

	private Date dataAdmissao;

	private String logradouro;

	private int numero;

	private String bairro;

	private String complemento;

	private String cidade;

	private String uf;

	private String cep;

	private Setor idSetor;

	private boolean ativo;

	// -------------------------------------------

	@EJB
	private FuncionarioService funcionarioService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.funcionario = this.funcionarioService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	public void logar() {

	}

	public void salvar() {

		try {

			if (this.funcionario.getId() == null) {
				this.funcionario.setAtivo(true);
			}

			this.funcionarioService.criar(this.funcionario);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/listagem/consultaFuncionario.xhtml");
	}

	public void editar() {

		this.doRedirect("/funcionarios/funcionario.xhtml?id=" + this.funcionario.getId());
	}

	public void remover() {

		try {

			this.funcionarioService.deletar(this.funcionario);
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

	// ------------------------------------------------

	public Funcionario getFuncionario() {

		return this.funcionario;
	}

	public void setFuncionario(final Funcionario funcionario) {

		this.funcionario = funcionario;
	}

	// ----------------------------------------------- get e set (carrega a lista para o redirecionamento da View).

	public List<Funcionario> getFuncionarios() throws BusinessException {

		this.funcionarios = (List<Funcionario>) this.funcionarioService.buscarTodos();
		return this.funcionarios;
	}

	public void setFuncionarios(final List<Funcionario> funcionarios) {

		this.funcionarios = funcionarios;
	}

	// ------------------------------------------------

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getUsuario() {

		return this.usuario;
	}

	public void setUsuario(final String usuario) {

		this.usuario = usuario;
	}

	public String getSenha() {

		return this.senha;
	}

	public void setSenha(final String senha) {

		this.senha = senha;
	}

	public int getRg() {

		return this.rg;
	}

	public void setRg(final int rg) {

		this.rg = rg;
	}

	public int getCpf() {

		return this.cpf;
	}

	public void setCpf(final int cpf) {

		this.cpf = cpf;
	}

	public String getFone() {

		return this.fone;
	}

	public void setFone(final String fone) {

		this.fone = fone;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public Date getDtNascimento() {

		return this.dtNascimento;
	}

	public void setDtNascimento(final Date dtNascimento) {

		this.dtNascimento = dtNascimento;
	}

	public Date getDataAdmissao() {

		return this.dataAdmissao;
	}

	public void setDataAdmissao(final Date dataAdmissao) {

		this.dataAdmissao = dataAdmissao;
	}

	public String getLogradouro() {

		return this.logradouro;
	}

	public void setLogradouro(final String logradouro) {

		this.logradouro = logradouro;
	}

	public int getNumero() {

		return this.numero;
	}

	public void setNumero(final int numero) {

		this.numero = numero;
	}

	public String getBairro() {

		return this.bairro;
	}

	public void setBairro(final String bairro) {

		this.bairro = bairro;
	}

	public String getComplemento() {

		return this.complemento;
	}

	public void setComplemento(final String complemento) {

		this.complemento = complemento;
	}

	public String getCidade() {

		return this.cidade;
	}

	public void setCidade(final String cidade) {

		this.cidade = cidade;
	}

	public String getUf() {

		return this.uf;
	}

	public void setUf(final String uf) {

		this.uf = uf;
	}

	public String getCep() {

		return this.cep;
	}

	public void setCep(final String cep) {

		this.cep = cep;
	}

	public Setor getIdSetor() {

		return this.idSetor;
	}

	public void setIdSetor(final Setor idSetor) {

		this.idSetor = idSetor;
	}

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

	public FuncionarioService getFuncionarioService() {

		return this.funcionarioService;
	}

	public void setFuncionarioService(final FuncionarioService funcionarioService) {

		this.funcionarioService = funcionarioService;
	}

}