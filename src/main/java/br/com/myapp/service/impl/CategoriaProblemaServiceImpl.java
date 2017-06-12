package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.CategoriaProblemaDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaProblema;
import br.com.myapp.service.CategoriaProblemaService;

@Stateless
public class CategoriaProblemaServiceImpl implements CategoriaProblemaService {

	@EJB
	private CategoriaProblemaDAO dao;

	@Override
	public void criar(final CategoriaProblema categoriaProblema) throws BusinessException {

		try {

			if (categoriaProblema.getId() == null) {
				this.dao.criar(categoriaProblema);
			} else {
				this.dao.atualizar(categoriaProblema);
			}

		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<CategoriaProblema> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final CategoriaProblema categoriaProblema) throws BusinessException {

		try {

			this.dao.atualizar(categoriaProblema);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final CategoriaProblema categoriaProblema) throws BusinessException {

		try {

			this.dao.deletar(categoriaProblema.getId());
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public CategoriaProblema buscar(final Long id) throws BusinessException {

		return this.dao.buscarById(id);
	}

}
