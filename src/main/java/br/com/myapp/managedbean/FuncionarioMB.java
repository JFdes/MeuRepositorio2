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
	
	//--------------------------------------------
	
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
	
	//-------------------------------------------

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
	
	public void logar(){
		
	}

	public void salvar() {

		try {

			if(funcionario.id==null) {
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
	
	
	//------------------------------------------------
	
	public Funcionario getFuncionario() {

		return this.funcionario;
	}

	public void setFuncionario(final Funcionario funcionario) {

		this.funcionario = funcionario;
	}

	
	//----------------------------------------------- get e set (carrega a lista para o redirecionamento da View).
	
	public List<Funcionario> getFuncionarios() throws BusinessException { 

		this.funcionarios = (List<Funcionario>) this.funcionarioService.buscarTodos();
		return this.funcionarios;
	}

	public void setFuncionarios(final List<Funcionario> funcionarios) {

		this.funcionarios = funcionarios;
	}

	
	//------------------------------------------------
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Setor getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Setor idSetor) {
		this.idSetor = idSetor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

		
	
}