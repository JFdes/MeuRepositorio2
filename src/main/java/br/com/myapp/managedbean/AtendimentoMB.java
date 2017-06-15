package br.com.myapp.managedbean;

import java.util.ArrayList;
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
import br.com.myapp.model.Atendimento;
import br.com.myapp.model.CategoriaProblema;
import br.com.myapp.model.Ciclo;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Problema;
import br.com.myapp.service.CategoriaProblemaService;
import br.com.myapp.service.CicloService;
import br.com.myapp.service.ClienteService;
import br.com.myapp.service.ProblemaService;

@ViewScoped
@ManagedBean
public class AtendimentoMB extends AbstractManagedBean<Atendimento> {

	private String tituloProblema;

	private String descricaoProblema;

	private Cliente cliente;

	private Ciclo ciclo;

	private Collection<Problema> problemas;

	private DualListModel<CategoriaProblema> categorias;

	@EJB
	private ClienteService clienteService;

	@EJB
	private CicloService cicloService;

	@EJB
	private CategoriaProblemaService categoriaProblemaService;

	@EJB
	private ProblemaService problemaService;

	@PostConstruct
	@Override
	public void init() {

		super.init();
	}

	@Override
	public void limpar() {

		this.tituloProblema = StringUtils.EMPTY;
		this.descricaoProblema = StringUtils.EMPTY;
		this.cliente = null;
		this.ciclo = null;
		this.categorias = new DualListModel<>();
	}

	@Override
	public void popularInterface() throws BusinessException {

		this.ciclo = this.cicloService.buscarCicloAtual();
	}

	@Override
	public void popularCampos(final Atendimento atendimento) throws BusinessException {

	}

	@Override
	public void popularObjeto(final Atendimento atendimento) {

	}

	@Override
	public void validarCampos() throws BusinessException {

	}

	@Override
	public void salvar(final Atendimento atendimento) throws BusinessException {

		final Problema problema = new Problema();
		problema.setTitulo(this.tituloProblema);
		problema.setDescricao(this.descricaoProblema);
		problema.setCiclo(this.ciclo);
		problema.setCategorias(this.categorias.getTarget());

		Collection<Problema> problemas = this.problemaService.buscarByCliente(this.cliente);

		if (CollectionUtils.isEmpty(problemas)) {
			problemas = new ArrayList<>();
		}

		problemas.add(problema);

		this.problemaService.criar(problemas, this.cliente);
		this.clienteService.atualizar(this.cliente);

	}

	@Override
	public void editar() {

	}

	@Override
	public void excluir(final Atendimento atendimento) throws BusinessException {

	}

	@Override
	public Class<Atendimento> getObjectClass() {

		return Atendimento.class;
	}

	public Collection<Cliente> getClientes() {

		try {
			return this.clienteService.buscarTodos();
		} catch (final BusinessException e) {
			this.exibirMensagemAviso("Falha ao carregar clientes!");
			return null;
		}
	}

	public void realizarAtendimento() {

		try {

			this.tituloProblema = StringUtils.EMPTY;
			this.descricaoProblema = StringUtils.EMPTY;
			this.categorias = new DualListModel<>();
			this.categorias.setSource((List<CategoriaProblema>) this.categoriaProblemaService.buscarTodos());
		} catch (final BusinessException e) {
			this.exibirMensagemAviso("Falha ao iniciar o atendimento!");
		}
	}

	public String getTituloProblema() {

		return this.tituloProblema;
	}

	public void setTituloProblema(final String tituloProblema) {

		this.tituloProblema = tituloProblema;
	}

	public String getDescricaoProblema() {

		return this.descricaoProblema;
	}

	public void setDescricaoProblema(final String descricaoProblema) {

		this.descricaoProblema = descricaoProblema;
	}

	public Cliente getCliente() {

		return this.cliente;
	}

	public void setCliente(final Cliente cliente) {

		this.cliente = cliente;
	}

	public Ciclo getCiclo() {

		return this.ciclo;
	}

	public void setCiclo(final Ciclo ciclo) {

		this.ciclo = ciclo;
	}

	public Collection<Problema> getProblemas() {

		return this.problemas;
	}

	public void setProblemas(final Collection<Problema> problemas) {

		this.problemas = problemas;
	}

	public DualListModel<CategoriaProblema> getCategorias() {

		return this.categorias;
	}

	public void setCategorias(final DualListModel<CategoriaProblema> categorias) {

		this.categorias = categorias;
	}

}
