package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.ClienteDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.service.ClienteService;

@Stateless
public class ClienteServiceImpl implements ClienteService {

	@EJB
	private ClienteDAO dao;

	@Override
	public void criar(final Cliente cliente) throws BusinessException {

		try {

			if(cliente.getId()==null){
				this.dao.criar(cliente);
			} else {
				this.atualizar(cliente);
			}
			
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Cliente> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Cliente cliente) throws BusinessException {

		try {

			this.dao.atualizar(cliente);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Cliente cliente) throws BusinessException {

		try {

			this.dao.deletar(cliente);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Cliente buscar(final Long id) throws BusinessException {

		return this.dao.buscar(id);
	}

}
