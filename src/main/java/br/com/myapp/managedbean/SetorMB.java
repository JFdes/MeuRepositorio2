package br.com.myapp.managedbean;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DualListModel;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.CategoriaProblema;
import br.com.myapp.model.Setor;
import br.com.myapp.service.CategoriaProblemaService;
import br.com.myapp.service.SetorService;

@ManagedBean
@ViewScoped
public class SetorMB extends AbstractManagedBean<Setor> {

	private String nome;

	private boolean ativo;

	private DualListModel<CategoriaProblema> categorias;

	@EJB
	private SetorService setorService;

	@EJB
	private CategoriaProblemaService categoriaProblemaService;

	@PostConstruct
	@Override
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				final Setor setor = this.setorService.buscar(Long.valueOf(id));
				this.setObjeto(setor);
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
		this.categorias = new DualListModel<CategoriaProblema>();
	}

	@Override
	public void popularInterface() throws BusinessException {

		final Collection<CategoriaProblema> categorias = this.categoriaProblemaService.buscarTodos();

		if (CollectionUtils.isNotEmpty(categorias)) {

			this.categorias.setSource((List<CategoriaProblema>) categorias);
		}
	}

	@Override
	public void popularCampos(final Setor setor) throws BusinessException {

		this.nome = setor.getNome();
		this.ativo = setor.isAtivo();

		this.categorias.getSource().removeAll(setor.getCategorias());
		this.categorias.setTarget((List<CategoriaProblema>) setor.getCategorias());
	}

	@Override
	public void popularObjeto(final Setor setor) {

		setor.setNome(this.nome);
		setor.setAtivo(this.ativo);
		setor.setCategorias(this.categorias.getTarget());

		if (setor.getId() == null) {
			setor.setUsuarioCriador(this.getUsuarioLogado());
			setor.setDataCriacao(Calendar.getInstance().getTime());
		} else {
			setor.setUsuarioAtualizador(this.getUsuarioLogado());
			setor.setDataAtualizacao(Calendar.getInstance().getTime());
		}
	}

	@Override
	public void validarCampos() throws BusinessException {

	}

	@Override
	public void salvar(final Setor setor) throws BusinessException {

		this.setorService.criar(setor);

		this.doRedirect("/listagem/consultaSetor.xhtml");
	}

	@Override
	public void editar() {

		try {
			this.doRedirect("/funcionarios/setor.xhtml?id=" + this.getItemSelecionado().getId());
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public void excluir(final Setor setor) throws BusinessException {

		try {
			this.setorService.deletar(setor);
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public Class<Setor> getObjectClass() {

		return Setor.class;
	}

	public Collection<Setor> getSetores() {

		try {
			return this.setorService.buscarTodos();
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

	public boolean isAtivo() {

		return this.ativo;
	}

	public void setAtivo(final boolean ativo) {

		this.ativo = ativo;
	}

	public DualListModel<CategoriaProblema> getCategorias() {

		return this.categorias;
	}

	public void setCategorias(final DualListModel<CategoriaProblema> categorias) {

		this.categorias = categorias;
	}

}