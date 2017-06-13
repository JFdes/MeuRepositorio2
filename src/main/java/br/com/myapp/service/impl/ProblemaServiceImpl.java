package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.ProblemaDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Problema;
import br.com.myapp.service.ProblemaService;

@Stateless
public class ProblemaServiceImpl implements ProblemaService {

	@EJB
	private ProblemaDAO dao;

	@Override
	public Collection<Problema> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Problema problema) throws BusinessException {

		try {

			this.dao.atualizar(problema);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Problema problema) throws BusinessException {

		try {

			this.dao.deletar(problema.getId());
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Problema buscar(final Long id) throws BusinessException {

		return this.dao.buscarById(id);
	}

	@Override
	public Collection<Problema> buscarByCliente(final Cliente cliente) throws BusinessException {

		return this.dao.buscarByCliente(cliente);
	}

	public void removerProblemasVinculados(final Cliente cliente) throws BusinessException {

		this.dao.deletarByCliente(cliente);
	}

	@Override
	public void criar(final Collection<Problema> problemas, final Cliente cliente) throws BusinessException {

		try {

			this.removerProblemasVinculados(cliente);

			if (problemas != null) {

				for (final Problema problema : problemas) {

					problema.setCliente(cliente);

					this.dao.criar(problema);
				}
			}
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

}
