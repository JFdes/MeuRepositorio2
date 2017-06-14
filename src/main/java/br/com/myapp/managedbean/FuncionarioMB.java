package br.com.myapp.managedbean;

import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Funcionario;
import br.com.myapp.model.Setor;
import br.com.myapp.service.FuncionarioService;
import br.com.myapp.service.SetorService;

@ManagedBean
@ViewScoped
public class FuncionarioMB extends AbstractManagedBean<Funcionario> {

	private String nome;

	private String rg;

	private String cpf;

	private String telefone;

	private String email;

	private Date dataNascimento;

	private Date dataAdmissao;

	private String logradouro;

	private String numero;

	private String bairro;

	private String complemento;

	private String cidade;

	private String uf;

	private String cep;

	private String usuario;

	private String senha;

	private Setor setor;

	private boolean ativo;

	private Collection<Setor> setores;

	@EJB
	private SetorService setorService;

	@EJB
	private FuncionarioService funcionarioService;

	@PostConstruct
	@Override
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				final Funcionario funcionario = this.funcionarioService.buscar(Long.valueOf(id));
				this.setObjeto(funcionario);
			} catch (final BusinessException e) {
				this.exibirMensagemErro(e);
			}
		}

		super.init();
	}

	@Override
	public void limpar() {

		this.nome = StringUtils.EMPTY;
		this.rg = StringUtils.EMPTY;
		this.cpf = StringUtils.EMPTY;
		this.telefone = StringUtils.EMPTY;
		this.email = StringUtils.EMPTY;
		this.dataNascimento = null;
		this.dataAdmissao = null;
		this.logradouro = StringUtils.EMPTY;
		this.numero = StringUtils.EMPTY;
		this.bairro = StringUtils.EMPTY;
		this.complemento = StringUtils.EMPTY;
		this.cidade = StringUtils.EMPTY;
		this.uf = StringUtils.EMPTY;
		this.cep = StringUtils.EMPTY;
		this.usuario = StringUtils.EMPTY;
		this.senha = StringUtils.EMPTY;
		this.setor = null;
		this.ativo = Boolean.TRUE;
	}

	@Override
	public void popularInterface() throws BusinessException {

		this.setores = this.setorService.buscarTodos();
	}

	@Override
	public void popularCampos(final Funcionario funcionario) throws BusinessException {

		this.nome = funcionario.getNome();
		this.rg = funcionario.getRg();
		this.cpf = funcionario.getCpf();
		this.telefone = funcionario.getTelefone();
		this.email = funcionario.getEmail();
		this.dataNascimento = funcionario.getDataNascimento();
		this.dataAdmissao = funcionario.getDataAdmissao();
		this.logradouro = funcionario.getLogradouro();
		this.numero = funcionario.getNumero();
		this.bairro = funcionario.getBairro();
		this.complemento = funcionario.getComplemento();
		this.cidade = funcionario.getCidade();
		this.uf = funcionario.getUf();
		this.cep = funcionario.getCep();
		this.usuario = funcionario.getUsuario();
		this.senha = funcionario.getSenha();
		this.setor = funcionario.getSetor();
		this.ativo = funcionario.isAtivo();
	}

	@Override
	public void popularObjeto(final Funcionario funcionario) {

		funcionario.setNome(this.nome);
		funcionario.setRg(this.rg);
		funcionario.setCpf(this.cpf);
		funcionario.setTelefone(this.telefone);
		funcionario.setEmail(this.email);
		funcionario.setDataNascimento(this.dataNascimento);
		funcionario.setDataAdmissao(this.dataAdmissao);
		funcionario.setLogradouro(this.logradouro);
		funcionario.setNumero(this.numero);
		funcionario.setBairro(this.bairro);
		funcionario.setCidade(this.cidade);
		funcionario.setComplemento(this.complemento);
		funcionario.setUf(this.uf);
		funcionario.setCep(this.cep);
		funcionario.setUsuario(this.usuario);
		funcionario.setSenha(this.senha);
		funcionario.setSetor(this.setor);
		funcionario.setAtivo(this.ativo);
	}

	@Override
	public void validarCampos() throws BusinessException {

	}

	@Override
	public void salvar(final Funcionario funcionario) throws BusinessException {

		this.funcionarioService.criar(funcionario);

		this.doRedirect("/listagem/consultaFuncionario.xhtml");

	}

	@Override
	public void editar() {

		try {
			this.doRedirect("/funcionarios/funcionario.xhtml?id=" + this.getItemSelecionado().getId());
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public void excluir(final Funcionario funcionario) throws BusinessException {

		try {
			this.funcionarioService.deletar(funcionario);
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public Class<Funcionario> getObjectClass() {

		return Funcionario.class;
	}

	public Collection<Funcionario> getFuncionarios() {

		try {
			return this.funcionarioService.buscarTodos();
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
			return null;
		}
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getRg() {

		return this.rg;
	}

	public void setRg(final String rg) {

		this.rg = rg;
	}

	public String getCpf() {

		return this.cpf;
	}

	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	public String getTelefone() {

		return this.telefone;
	}

	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
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

	public Setor getSetor() {

		return this.setor;
	}

	public void setSetor(final Setor setor) {

		this.setor = setor;
	}

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

	public Collection<Setor> getSetores() {

		return this.setores;
	}

	public void setSetores(final Collection<Setor> setores) {

		this.setores = setores;
	}

}