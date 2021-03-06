package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.collections4.CollectionUtils;

import br.com.myapp.dao.CategoriaClienteDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Cliente;
import br.com.myapp.service.CategoriaClienteService;
import br.com.myapp.service.ClienteService;

@Stateless
public class CategoriaClienteServiceImpl implements CategoriaClienteService {

	@EJB
	private ClienteService clienteService;

	@EJB
	private CategoriaClienteDAO dao;

	@Override
	public void criar(final CategoriaCliente categoriaCliente) throws BusinessException {

		try {

			if (categoriaCliente.getId() == null) {
				this.dao.criar(categoriaCliente);
			} else {
				this.dao.atualizar(categoriaCliente);
			}
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<CategoriaCliente> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final CategoriaCliente categoriaCliente) throws BusinessException {

		try {

			this.dao.atualizar(categoriaCliente);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final CategoriaCliente categoriaCliente) throws BusinessException {

		try {

			this.removerClientesVinculados(categoriaCliente);

			this.dao.deletar(categoriaCliente.getId());
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public CategoriaCliente buscar(final Long id) throws BusinessException {

		return this.dao.buscarById(id);
	}

	private void removerClientesVinculados(final CategoriaCliente categoriaCliente) throws BusinessException {

		final Collection<Cliente> clientes = this.clienteService.buscarByCategoriaCliente(categoriaCliente);

		if (CollectionUtils.isNotEmpty(clientes)) {

			for (final Cliente cliente : clientes) {

				cliente.setCategoria(null);
				this.clienteService.atualizar(cliente);
			}
		}
	}

}
