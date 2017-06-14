package br.com.myapp.managedbean;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Ciclo;
import br.com.myapp.service.CicloService;

@ManagedBean
@ViewScoped
public class CicloMB extends AbstractManagedBean<Ciclo> {

	private String descricao;

	private Date dataInicio;

	private Date dataFim;

	@EJB
	private CicloService cicloService;

	@PostConstruct
	@Override
	public void init() {

		final String id = this.getParam("id");

		if (StringUtils.isNotBlank(id)) {

			try {
				final Ciclo ciclo = this.cicloService.buscar(Long.valueOf(id));
				this.setObjeto(ciclo);
			} catch (final BusinessException e) {
				this.exibirMensagemErro(e);
			}
		}

		super.init();
	}

	@Override
	public void limpar() {

		this.descricao = StringUtils.EMPTY;
		this.dataInicio = null;
		this.dataFim = null;
	}

	@Override
	public void popularInterface() throws BusinessException {

	}

	@Override
	public void popularCampos(final Ciclo ciclo) throws BusinessException {

		this.descricao = ciclo.getDescricao();
		this.dataInicio = ciclo.getDataInicio();
		this.dataFim = ciclo.getDataFim();
	}

	@Override
	public void popularObjeto(final Ciclo ciclo) {

		ciclo.setDescricao(this.descricao);
		ciclo.setDataInicio(this.dataInicio);
		ciclo.setDataFim(this.dataFim);

		if (ciclo.getId() == null) {
			ciclo.setUsuarioCriador("ADMIN");
			ciclo.setDataCriacao(Calendar.getInstance().getTime());
		} else {
			ciclo.setUsuarioAtualizador("ADMIN");
			ciclo.setDataAtualizacao(Calendar.getInstance().getTime());
		}
	}

	@Override
	public void validarCampos() throws BusinessException {

	}

	@Override
	public void salvar(final Ciclo ciclo) throws BusinessException {

		this.cicloService.criar(ciclo);

		this.doRedirect("/listagem/consultaCiclo.xhtml");
	}

	@Override
	public void editar() {

		try {
			this.doRedirect("/ciclos/ciclo.xhtml?id=" + this.getItemSelecionado().getId());
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public void excluir(final Ciclo ciclo) throws BusinessException {

		try {
			this.cicloService.deletar(ciclo);
		} catch (final BusinessException e) {
			this.exibirMensagemErro(e);
		}
	}

	@Override
	public Class<Ciclo> getObjectClass() {

		return Ciclo.class;
	}

	public Collection<Ciclo> getCiclos() {

		try {
			return this.cicloService.buscarTodos();
		} catch (final Exception e) {
			this.exibirMensagemErro(e);
			return null;
		}
	}

	public String getDescricao() {

		return this.descricao;
	}

	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}

	public Date getDataInicio() {

		return this.dataInicio;
	}

	public void setDataInicio(final Date dataInicio) {

		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {

		return this.dataFim;
	}

	public void setDataFim(final Date dataFim) {

		this.dataFim = dataFim;
	}

}