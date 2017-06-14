package br.com.myapp.managedbean;

import java.util.Calendar;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.CampoInvalidoException;
import br.com.myapp.model.CategoriaProblema;
import br.com.myapp.service.CategoriaProblemaService;

@ManagedBean
@ViewScoped
public class CategoriaProblemaMB extends AbstractManagedBean<CategoriaProblema> {

	private String nome;

	private boolean ativo;

	@EJB
	private CategoriaProblemaService categoriaProblemaService;

	@PostConstruct
	@Override
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				final CategoriaProblema categoriaProblema = this.categoriaProblemaService.buscar(Long.valueOf(id));
				this.setObjeto(categoriaProblema);
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
	public void popularCampos(final CategoriaProblema categoriaProblema) throws BusinessException {

		this.nome = categoriaProblema.getNome();
		this.ativo = categoriaProblema.isAtivo();
	}

	@Override
	public void popularObjeto(final CategoriaProblema categoriaProblema) {

		categoriaProblema.setNome(this.nome);
		categoriaProblema.setAtivo(this.ativo);

		if (categoriaProblema.getId() == null) {
			categoriaProblema.setUsuarioCriador("ADMIN");
			categoriaProblema.setDataCriacao(Calendar.getInstance().getTime());
		} else {
			categoriaProblema.setUsuarioAtualizador("ADMIN");
			categoriaProblema.setDataAtualizacao(Calendar.getInstance().getTime());
		}
	}

	@Override
	public void validarCampos() throws BusinessException {

		if (StringUtils.isBlank(this.nome)) {
			throw new CampoInvalidoException("nome");
		}
	}

	@Override
	public void salvar(final CategoriaProblema categoriaProblema) throws BusinessException {

		this.categoriaProblemaService.criar(categoriaProblema);

		this.doRedirect("/listagem/consultaCategoriaProblema.xhtml");
	}

	@Override
	public void editar() {

		try {
			this.doRedirect("/problemas/categoriaProblema.xhtml?id=" + this.getItemSelecionado().getId());
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public void excluir(final CategoriaProblema categoriaProblema) throws BusinessException {

		this.categoriaProblemaService.deletar(categoriaProblema);
	}

	public Collection<CategoriaProblema> getCategorias() {

		try {
			return this.categoriaProblemaService.buscarTodos();
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
			return null;
		}
	}

	@Override
	public Class<CategoriaProblema> getObjectClass() {

		return CategoriaProblema.class;
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