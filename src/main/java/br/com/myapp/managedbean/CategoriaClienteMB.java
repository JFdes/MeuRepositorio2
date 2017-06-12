package br.com.myapp.managedbean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.CampoInvalidoException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.service.CategoriaClienteService;
import br.com.myapp.util.DateUtil;

@ManagedBean
@ViewScoped
public class CategoriaClienteMB extends AbstractManagedBean<CategoriaCliente> {

	private String nome;

	private boolean ativo;

	@EJB
	private CategoriaClienteService categoriaClienteService;

	@PostConstruct
	@Override
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {

				final CategoriaCliente categoriaCliente = this.categoriaClienteService.buscar(Long.valueOf(id));
				this.setObjeto(categoriaCliente);
			} catch (final BusinessException e) {
				this.exibirMensagemErro(e);
			}
		}

		super.init();
	}

	@Override
	public void limpar() {

		this.nome = StringUtils.EMPTY;
		this.ativo = Boolean.TRUE;
	}

	@Override
	public void popularInterface() throws BusinessException {

	}

	@Override
	public void popularCampos(final CategoriaCliente categoriaCliente) throws BusinessException {

		this.nome = categoriaCliente.getCategoria();
		this.ativo = categoriaCliente.isAtivo();
	}

	@Override
	public void popularObjeto(final CategoriaCliente categoriaCliente) {

		categoriaCliente.setCategoria(this.nome);
		categoriaCliente.setAtivo(this.ativo);

		if (categoriaCliente.getId() == null) {

			categoriaCliente.setUsuarioCriador("ADMIN");
			categoriaCliente.setDataCriacao(DateUtil.getCurrent());
		} else {

			categoriaCliente.setUsuarioAtualizador("ADMIN");
			categoriaCliente.setDataAtualizacao(DateUtil.getCurrent());
		}
	}

	@Override
	public void validarCampos() throws BusinessException {

		if(StringUtils.isBlank(this.nome)) {
			throw new CampoInvalidoException("Nome");
		}
	}

	@Override
	public void salvar(final CategoriaCliente categoriaCliente) throws BusinessException {

		this.categoriaClienteService.criar(categoriaCliente);

		this.doRedirect("/listagem/consultaCategoriaCliente.xhtml");
	}

	@Override
	public void editar() {

		try {
			this.doRedirect("/clientes/categoriaCliente.xhtml?id=" + this.getItemSelecionado().getId());
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public void excluir(final CategoriaCliente categoriaCliente) throws BusinessException {

		try {
			this.categoriaClienteService.deletar(categoriaCliente);
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public Class<CategoriaCliente> getObjectClass() {

		return CategoriaCliente.class;
	}

	public Collection<CategoriaCliente> getCategorias() {

		try {
			return this.categoriaClienteService.buscarTodos();
		} catch (final BusinessException e) {
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

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

}