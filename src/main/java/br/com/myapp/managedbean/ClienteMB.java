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
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Cliente;
import br.com.myapp.service.ClienteService;

@ManagedBean
@ViewScoped
public class ClienteMB {

	

	private String usuarioCriador;
	
	private String usuarioAtualizador;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
	
	private String nomeFantasia;
	
	private String cnpj;
	
	private String razaoSocial;
	
	private String inscest;
	
	private String email;
	
	private String RegimeTributario;
	
	private CategoriaCliente idCategoriaCliente;
	
	private String logradouro;
	
	private String numero;
	
	private String bairro;
	
	private String complemento;
	
	private String cidade;
	
	private String uf;
	
	private String cep;
	
	private String pontoReferencia;
	
	private String proprietario;
		
	private Date dataNascimento;
	
	private boolean ativo;


	//----------------------------------------------------------
	
	private Cliente cliente = new Cliente();

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	//-----------------------------------------------------------

	@EJB
	private ClienteService clienteService;

	@PostConstruct
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				this.cliente = this.clienteService.buscar(Long.valueOf(id));
			} catch (final BusinessException e) {
				e.printStackTrace();
			}
		}
	}

	//-----------------------------------------------------
	
	public void salvar() {

		try {

			this.clienteService.criar(this.cliente);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}

		this.doRedirect("/listagem/consultaCliente.xhtml");
	}


//-----------------------------------------------------
	
	public void editar() {

		this.doRedirect("/clientes/cliente.xhtml?id=" + this.cliente.getId());
	}

//-----------------------------------------------------
	
	public void remover() {

		try {

			this.clienteService.deletar(this.cliente);
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

	
	//-----------------------------------------------------
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getInscest() {
		return inscest;
	}

	public void setInscest(String inscest) {
		this.inscest = inscest;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegimeTributario() {
		return RegimeTributario;
	}

	public void setRegimeTributario(String regimeTributario) {
		RegimeTributario = regimeTributario;
	}

	public CategoriaCliente getIdCategoriaCliente() {
		return idCategoriaCliente;
	}

	public void setIdCategoriaCliente(CategoriaCliente idCategoriaCliente) {
		this.idCategoriaCliente = idCategoriaCliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	
}