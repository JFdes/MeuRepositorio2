package br.com.myapp.managedbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Transient;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DualListModel;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Atendimento;
import br.com.myapp.model.CategoriaProblema;
import br.com.myapp.model.Ciclo;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Problema;
import br.com.myapp.model.StatusProblema;
import br.com.myapp.service.AtendimentoService;
import br.com.myapp.service.CategoriaProblemaService;
import br.com.myapp.service.CicloService;
import br.com.myapp.service.ClienteService;
import br.com.myapp.service.ProblemaService;
import br.com.myapp.util.DateUtil;

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

	@EJB
	private AtendimentoService atendimentoService;

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
		this.problemas = new ArrayList<>();
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

		atendimento.setCliente(this.cliente.getId());
		atendimento.setCiclo(this.ciclo.getId());
		atendimento.setFuncionario(this.getFuncionarioLogado() != null ? this.getFuncionarioLogado().getId() : null);
		atendimento.setDataAtendimento(DateUtil.getCurrent());
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
		problema.setStatus(StatusProblema.ABERTO);

		Collection<Problema> problemas = this.problemaService.buscarByCliente(this.cliente);

		if (CollectionUtils.isEmpty(problemas)) {
			problemas = new ArrayList<>();
		}

		problemas.add(problema);

		this.problemaService.criar(problemas, this.cliente);
		this.clienteService.atualizar(this.cliente);
		this.atendimentoService.criar(atendimento);
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

	public void visualizarProblemas() {

		try {

			this.problemas = this.problemaService.buscarByCliente(this.cliente);
		} catch (final BusinessException e) {
			this.exibirMensagemAviso("Falha ao iniciar modal de problemas!");
		}
	}

	public void atualizarProblemas() {

		try {
			this.problemaService.criar(this.problemas, this.cliente);
		} catch (final BusinessException e) {
			this.exibirMensagemErro("Erro ao tentar atualizar os problemas do cliente.");
		}
	}

	public Collection<StatusProblema> getListaStatusProblema() {

		return Arrays.asList(StatusProblema.values());
	}

	//----------------------------------------
	
	
	@Transient
	private String imagemQuadroStatus=""; 

	
	//-----------------------------------------
	
	
	public String getStatusCliente(final Cliente cliente) {

		try {
			final Collection<Atendimento> atendimentos = this.atendimentoService.buscarByClienteCiclo(cliente, this.ciclo);

			if (CollectionUtils.isEmpty(atendimentos)) {
								
				return "Atendimento não realizado neste ciclo";
			} else {

				final Collection<Problema> problemasAbertos = this.problemaService.buscarProblemasAbertosByCliente(cliente);

				if (CollectionUtils.isEmpty(problemasAbertos)) {
					return "OK";
				} else {
					return "PROBLEMA NÃO RESOLVIDO";
				}
			}
		} catch (final BusinessException e) {
			this.exibirMensagemErro("Falha ao recuperar status!");
			return StringUtils.EMPTY;
		}

	}
	
	//-----------------------------------------
	public String getStatusClienteSinalizador(final Cliente cliente) {

		try {
			final Collection<Atendimento> atendimentos = this.atendimentoService.buscarByClienteCiclo(cliente, this.ciclo);

			if (CollectionUtils.isEmpty(atendimentos)) {
				this.imagemQuadroStatus="../resources/images/branco.png";
				cliente.setImagemQuadroStatus(imagemQuadroStatus);
				return imagemQuadroStatus;
			} else {

				final Collection<Problema> problemasAbertos = this.problemaService.buscarProblemasAbertosByCliente(cliente);

				if (CollectionUtils.isEmpty(problemasAbertos)) {
					
					this.imagemQuadroStatus="../resources/images/verde.png";
					cliente.setImagemQuadroStatus(imagemQuadroStatus);
					return imagemQuadroStatus;
				} else {
					this.imagemQuadroStatus="../resources/images/vermelho.png";
					cliente.setImagemQuadroStatus(imagemQuadroStatus);
					return imagemQuadroStatus;
				}
			}
		} catch (final BusinessException e) {
			this.exibirMensagemErro("Falha ao recuperar status!");
			return StringUtils.EMPTY;
		}

	}
	
	
	
	//-------------------------------------

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
	
	//------------------------------
	
	public void verQuadro(){
		this.doRedirect("/listagem/sinalizador.xhtml");
	}

}
