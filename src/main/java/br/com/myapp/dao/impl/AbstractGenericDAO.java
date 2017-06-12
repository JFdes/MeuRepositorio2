package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.myapp.dao.GenericDAO;
import br.com.myapp.exception.DAOException;

public abstract class AbstractGenericDAO<T, K> implements GenericDAO<T, K> {

	@Override
	public void criar(final T objeto) throws DAOException {

		try {

			this.getEntityManager().persist(objeto);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final K id) throws DAOException {

		try {

			final T entity = this.buscarById(id);
			final T mergedEntity = this.getEntityManager().merge(entity);
			this.getEntityManager().remove(mergedEntity);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final T objeto) throws DAOException {

		try {

			this.getEntityManager().merge(objeto);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public T buscarById(final K id) throws DAOException {

		try {

			return this.getEntityManager().find(this.getEntityClass(), id);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {

		try {

			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<T> query = builder.createQuery(this.getEntityClass());
			query.from(this.getEntityClass());

			return this.getEntityManager().createQuery(query).getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	public abstract EntityManager getEntityManager();

	protected abstract Class<T> getEntityClass();

}
