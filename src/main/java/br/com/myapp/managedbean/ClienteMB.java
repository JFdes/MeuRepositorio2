package br.com.myapp.managedbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Telefone;
import br.com.myapp.service.CategoriaClienteService;
import br.com.myapp.service.ClienteService;

@ManagedBean
@ViewScoped
public class ClienteMB extends AbstractManagedBean<Cliente> {

	private String nomeFantasia;

	private String cnpj;

	private String razaoSocial;

	private String inscest;

	private String email;

	private String regimeTributario;

	private CategoriaCliente categoria;

	private String logradouro;

	private String numero;

	private String bairro;

	private String complemento;

	private String cidade;

	private String uf;

	private String cep;

	private String pontoReferencia;

	private String nomeProprietario;

	private Date dataNascimento;

	private boolean status;

	private String dddComercial;

	private String numeroComercial;

	private String dddCelular;

	private String numeroCelular;

	private Collection<CategoriaCliente> categorias;

	@EJB
	private ClienteService clienteService;

	@EJB
	private CategoriaClienteService categoriaClienteService;

	@PostConstruct
	@Override
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				final Cliente cliente = this.clienteService.buscar(Long.valueOf(id));
				this.setObjeto(cliente);
			} catch (final BusinessException e) {
				this.exibirMensagemErro(e);
			}
		}

		super.init();
	}

	@Override
	public void limpar() {

		this.nomeFantasia = StringUtils.EMPTY; // StringUtils.EMPTY; -> cria instancia vazia
		this.cnpj = StringUtils.EMPTY;
		this.razaoSocial = StringUtils.EMPTY;
		this.inscest = StringUtils.EMPTY;
		this.email = StringUtils.EMPTY;
		this.regimeTributario = StringUtils.EMPTY;
		this.categoria = null;
		this.logradouro = StringUtils.EMPTY;
		this.numero = StringUtils.EMPTY;
		this.bairro = StringUtils.EMPTY;
		this.complemento = StringUtils.EMPTY;
		this.cidade = StringUtils.EMPTY;
		this.uf = StringUtils.EMPTY;
		this.pontoReferencia = StringUtils.EMPTY;
		this.status = Boolean.TRUE;

	}

	@Override
	public void popularInterface() throws BusinessException {

		this.categorias = this.categoriaClienteService.buscarTodos();

	}

	@Override
	public void popularCampos(final Cliente cliente) throws BusinessException {

		this.nomeFantasia = cliente.getNomeFantasia();
		this.cnpj = cliente.getCnpj();
		this.razaoSocial = cliente.getRazaoSocial();
		this.inscest = cliente.getInscest();
		this.email = cliente.getEmail();
		this.regimeTributario = cliente.getRegimeTributario();
		this.categoria = cliente.getIdCategoriaCliente();
		this.logradouro = cliente.getLogradouro();
		this.numero = cliente.getNumero();
		this.bairro = cliente.getBairro();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.uf = cliente.getUf();
		this.pontoReferencia = cliente.getPontoReferencia();
		this.nomeProprietario = cliente.getProprietario();
		this.dataNascimento = cliente.getDataNascimento();
		this.status = cliente.isAtivo();

		if (cliente.getTelefones() != null) {

			for (final Telefone telefone : cliente.getTelefones()) {

				if ("CELULAR".equalsIgnoreCase(telefone.getTipo())) {
					this.dddCelular = telefone.getDdd();
					this.numeroCelular = telefone.getNumero();
				} else if ("COMERCIAL".equalsIgnoreCase(telefone.getTipo())) {
					this.dddComercial = telefone.getDdd();
					this.numeroComercial = telefone.getNumero();
				}
			}
		}

	}

	@Override
	public void popularObjeto(final Cliente cliente) {

		cliente.setNomeFantasia(this.nomeFantasia);
		cliente.setCnpj(this.cnpj);
		cliente.setRazaoSocial(this.razaoSocial);
		cliente.setInscest(this.inscest);
		cliente.setEmail(this.email);
		cliente.setRegimeTributario(this.regimeTributario);
		cliente.setIdCategoriaCliente(this.categoria);
		cliente.setLogradouro(this.logradouro);
		cliente.setNumero(this.numero);
		cliente.setBairro(this.bairro);
		cliente.setComplemento(this.complemento);
		cliente.setCidade(this.cidade);
		cliente.setUf(this.uf);
		cliente.setPontoReferencia(this.pontoReferencia);
		cliente.setProprietario(this.nomeProprietario);
		cliente.setDataNascimento(this.dataNascimento);
		cliente.setAtivo(this.status);

		// final Telefone telefoneCelular = new Telefone();
		// telefoneCelular.setDdd(this.dddCelular);
		// telefoneCelular.setNumero(this.numeroCelular);
		// telefoneCelular.setTipo("CELULAR");
		//
		// final Telefone telefoneComercial = new Telefone();
		// telefoneComercial.setDdd(this.dddComercial);
		// telefoneComercial.setNumero(this.numeroComercial);
		// telefoneComercial.setTipo("COMERCIAL");

		final Telefone telefoneCelular = new Telefone();
		telefoneCelular.setDdd("81");
		telefoneCelular.setNumero("9999-9999");
		telefoneCelular.setTipo("CELULAR");
		telefoneCelular.setCliente(cliente);

		final Telefone telefoneComercial = new Telefone();
		telefoneComercial.setDdd("81");
		telefoneComercial.setNumero("3030-3030");
		telefoneComercial.setTipo("COMERCIAL");
		telefoneComercial.setCliente(cliente);

		final Collection<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefoneCelular);
		telefones.add(telefoneComercial);

		cliente.setTelefones(telefones);

		if (cliente.getId() == null) {
			cliente.setUsuarioCriador("ADMIN");
			cliente.setDataCriacao(Calendar.getInstance().getTime());
		} else {
			cliente.setUsuarioAtualizador("ADMIN");
			cliente.setDataAtualizacao(Calendar.getInstance().getTime());
		}

	}

	@Override
	public void validarCampos() throws BusinessException {

		if (StringUtils.isBlank(this.nomeFantasia)) {

			throw new BusinessException("O campo Nome Fantasia não pode ser vazio!");
		}
	}

	@Override
	public void salvar(final Cliente cliente) throws BusinessException {

		this.clienteService.criar(cliente);
	}

	@Override
	public void editar() {

	}

	@Override
	public void excluir(final Cliente itemSelecionado) throws BusinessException {

	}

	@Override
	public Class<Cliente> getObjectClass() {

		return Cliente.class;
	}

	public String getNomeFantasia() {

		return this.nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {

		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {

		return this.cnpj;
	}

	public void setCnpj(final String cnpj) {

		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {

		return this.razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {

		this.razaoSocial = razaoSocial;
	}

	public String getInscest() {

		return this.inscest;
	}

	public void setInscest(final String inscest) {

		this.inscest = inscest;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public String getRegimeTributario() {

		return this.regimeTributario;
	}

	public void setRegimeTributario(final String regimeTributario) {

		this.regimeTributario = regimeTributario;
	}

	public CategoriaCliente getCategoria() {

		return this.categoria;
	}

	public void setCategoria(final CategoriaCliente categoria) {

		this.categoria = categoria;
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

	public String getPontoReferencia() {

		return this.pontoReferencia;
	}

	public void setPontoReferencia(final String pontoReferencia) {

		this.pontoReferencia = pontoReferencia;
	}

	public String getNomeProprietario() {

		return this.nomeProprietario;
	}

	public void setNomeProprietario(final String nomeProprietario) {

		this.nomeProprietario = nomeProprietario;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public boolean getStatus() {

		return this.status;
	}

	public void setStatus(final boolean status) {

		this.status = status;
	}

	public String getDddComercial() {

		return this.dddComercial;
	}

	public void setDddComercial(final String dddComercial) {

		this.dddComercial = dddComercial;
	}

	public String getNumeroComercial() {

		return this.numeroComercial;
	}

	public void setNumeroComercial(final String numeroComercial) {

		this.numeroComercial = numeroComercial;
	}

	public String getDddCelular() {

		return this.dddCelular;
	}

	public void setDddCelular(final String dddCelular) {

		this.dddCelular = dddCelular;
	}

	public String getNumeroCelular() {

		return this.numeroCelular;
	}

	public void setNumeroCelular(final String numeroCelular) {

		this.numeroCelular = numeroCelular;
	}

	public Collection<CategoriaCliente> getCategorias() {

		return this.categorias;
	}

	public void setCategorias(final Collection<CategoriaCliente> categorias) {

		this.categorias = categorias;
	}

}