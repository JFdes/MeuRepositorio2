package br.com.myapp.managedbean;

import java.io.IOException;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Funcionario;
import br.com.myapp.util.Constants;
import br.com.myapp.util.ExceptionUtils;

public abstract class AbstractManagedBean<T> { // <T> -> Generics

	private static final String MENSAGEM_SUCESSO = "Operação realizada com sucesso!";

	private static final String MENSAGEM_ERRO = "Ops!!! Ocorreu um erro ao realizar a operação : %s";

	private static final String JAVA_SCRIPT_SHOW_MODAL = "PF(%s).show();";

	private T objeto;

	private T itemSelecionado;

	public abstract void limpar();

	public abstract void popularInterface() throws BusinessException;

	public abstract void popularCampos(T object) throws BusinessException;

	public abstract void popularObjeto(T object);

	public abstract void validarCampos() throws BusinessException;;

	public abstract void salvar(T object) throws BusinessException;

	public abstract void editar();

	public abstract void excluir(T itemSelecionado) throws BusinessException;

	public abstract Class<T> getObjectClass();

	public void init() {

		this.limpar();

		try {

			this.popularInterface();

			if (this.objeto != null) {
				this.popularCampos(this.objeto);
			}

		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	public void salvar() {

		try {

			this.validarCampos();

			this.setObjeto(this.getObjeto() == null ? this.getObjectClass().newInstance() : this.getObjeto());

			this.popularObjeto(this.getObjeto());

			this.salvar(this.getObjeto());

			this.exibirMensagemSucesso();

			this.setObjeto(null);

		} catch (final Exception e) {
			this.exibirMensagemErro(e);
		}

	}

	public void excluir() {

		try {
			this.excluir(this.getItemSelecionado());
			this.exibirMensagemSucesso();
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	/**
	 * 
	 * @see #exibirMensagem(Severity, String, String)
	 * 
	 * @param mensagem
	 * @param erro
	 */
	public void exibirMensagemErro(final Throwable erro) {

		this.exibirMensagemErro(String.format(AbstractManagedBean.MENSAGEM_ERRO,
				ExceptionUtils.removeClasseDeExceptionNaMensagem(erro.getMessage())));
	}

	/**
	 * 
	 * @see #exibirMensagem(Severity, String, String)
	 */
	public void exibirMensagemErro(final String mensagem) {

		this.exibirMensagem(FacesMessage.SEVERITY_ERROR, "Erro!", mensagem);
	}

	/**
	 * 
	 * @see #exibirMensagem(Severity, String, String)
	 */
	public void exibirMensagemInformativa(final String mensagem) {

		this.exibirMensagem(FacesMessage.SEVERITY_INFO, "Informativo!", mensagem);
	}

	/**
	 * 
	 * @see #exibirMensagem(Severity, String, String)
	 */
	public void exibirMensagemAviso(final String mensagem) {

		this.exibirMensagem(FacesMessage.SEVERITY_WARN, "Aviso!", mensagem);
	}

	/**
	 * 
	 * Exibe um modal com a mensagem passada como parâmetro.
	 * 
	 * @param severidade
	 *            da mensagem a ser exibida.
	 *            <ul>
	 *            <li>FacesMessage.SEVERITY_ERROR</li>
	 *            <li>FacesMessage.SEVERITY_FATAl</li>
	 *            <li>FacesMessage.SEVERITY_INFO</li>
	 *            <li>FacesMessage.SEVERITY_WARN</li>
	 *            </ul>
	 * @param titulo
	 *            texto a ser exibido no cabeçalho do modal da mensagem.
	 * @param mensagem
	 *            conteúdo do texto que será exibido.
	 */
	private void exibirMensagem(final Severity severidade, final String titulo, final String mensagem) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidade, "Aviso!", mensagem));
	}

	/**
	 * 
	 * @see #exibirMensagem(Severity, String, String)
	 */
	public void exibirMensagemSucesso() {

		this.exibirMensagem(FacesMessage.SEVERITY_INFO, "Aviso!", AbstractManagedBean.MENSAGEM_SUCESSO);
	}

	public String getParam(final String param) {

		final FacesContext context = FacesContext.getCurrentInstance();
		final Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
		final String value = paramMap.get(param);
		return value;
	}

	public Funcionario getFuncionarioLogado() {

		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		final HttpSession session = (HttpSession) externalContext.getSession(false);
		final Funcionario funcionario = (Funcionario) session.getAttribute(Constants.Login.FUNCIONARIO_LOGADO);

		return funcionario != null ? funcionario : null;
	}

	public String getUsuarioLogado() {

		final Funcionario funcionario = this.getFuncionarioLogado();
		return funcionario != null ? funcionario.getUsuario() : StringUtils.EMPTY;
	}

	public void doRedirect(final String redirectPage) throws FacesException {

		try {

			final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect(externalContext.getRequestContextPath().concat(redirectPage));
		} catch (final IOException e) {
			throw new FacesException(e);
		}
	}

	public void exibirModal(final String idModal) {

		RequestContext.getCurrentInstance().execute(String.format(
				AbstractManagedBean.JAVA_SCRIPT_SHOW_MODAL, StringUtils.defaultIfBlank(idModal,
						StringUtils.EMPTY)));
	}

	public T getObjeto() {

		return this.objeto;
	}

	public void setObjeto(final T objeto) {

		this.objeto = objeto;
	}

	public T getItemSelecionado() {

		return this.itemSelecionado;
	}

	public void setItemSelecionado(final T itemSelecionado) {

		this.itemSelecionado = itemSelecionado;
	}

}
