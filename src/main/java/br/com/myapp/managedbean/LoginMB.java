package br.com.myapp.managedbean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Funcionario;
import br.com.myapp.model.Setor;
import br.com.myapp.model.SetorEN;
import br.com.myapp.service.FuncionarioService;
import br.com.myapp.util.Constants;

@ViewScoped
@ManagedBean
public class LoginMB extends AbstractManagedBean<Funcionario> {

	private String usuario;

	private String senha;

	@EJB
	private FuncionarioService funcionarioService;

	@PostConstruct
	@Override
	public void init() {

		super.init();
	}

	@Override
	public void limpar() {

		this.usuario = StringUtils.EMPTY;
		this.senha = StringUtils.EMPTY;
	}

	@Override
	public void popularInterface() throws BusinessException {

	}

	@Override
	public void popularCampos(final Funcionario object) throws BusinessException {

	}

	@Override
	public void popularObjeto(final Funcionario object) {

	}

	@Override
	public void validarCampos() throws BusinessException {

	}

	@Override
	public void salvar(final Funcionario object) throws BusinessException {

	}

	@Override
	public void editar() {

	}

	@Override
	public void excluir(final Funcionario itemSelecionado) throws BusinessException {

	}

	public void login() {

		try {

			final Funcionario funcionario = this.funcionarioService.buscar(this.usuario, this.senha);

			if (funcionario == null) {
				this.exibirMensagemAviso("Funcionário não encontrado! Favor verificar usuário e senha.");
			} else {

				final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				final HttpSession session = (HttpSession) externalContext.getSession(false);
				session.setAttribute(Constants.Login.FUNCIONARIO_LOGADO, funcionario);

				final Setor setor = funcionario.getSetor();

				if (setor == null) {
					this.exibirMensagemAviso("Você não está vinculado a nenhum setor! Contate o administrador.");
				} else if (SetorEN.ATENDIMENTO.equals(SetorEN.get(setor.getNome()))) {
					this.doRedirect("/quadro.xhtml");
				} else {
					this.doRedirect("/index.xhtml");
				}
			}
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public Class<Funcionario> getObjectClass() {

		return Funcionario.class;
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

}
