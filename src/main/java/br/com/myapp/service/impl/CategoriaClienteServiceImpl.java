package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.CategoriaClienteDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.service.CategoriaClienteService;

@Stateless
public class CategoriaClienteServiceImpl implements CategoriaClienteService {

	@EJB
	private CategoriaClienteDAO dao;

	@Override
	public void criar(final CategoriaCliente categoriaCliente) throws BusinessException {

		try {

			if (categoriaCliente.getId() == null) {
				this.dao.criar(categoriaCliente);
			} else {
				this.atualizar(categoriaCliente);
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

			this.dao.deletar(categoriaCliente);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public CategoriaCliente buscar(final Long id) throws BusinessException {

		return this.dao.buscar(id);
	}

}
