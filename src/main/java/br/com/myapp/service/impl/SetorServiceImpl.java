package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.SetorDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Setor;
import br.com.myapp.service.SetorService;

@Stateless
public class SetorServiceImpl implements SetorService {

	@EJB
	private SetorDAO dao;

	@Override
	public void criar(final Setor setor) throws BusinessException {

		try {

			if (setor.getId() == null) {
				this.dao.criar(setor);
			} else {
				this.atualizar(setor);
			}

		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Setor> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Setor setor) throws BusinessException {

		try {

			this.dao.atualizar(setor);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Setor setor) throws BusinessException {

		try {

			this.dao.deletar(setor);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Setor buscar(final Long id) throws BusinessException {

		return this.dao.buscar(id);
	}

}
