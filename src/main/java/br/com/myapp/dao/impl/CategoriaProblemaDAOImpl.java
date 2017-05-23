package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.CategoriaProblemaDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaProblema;

@Stateless
public class CategoriaProblemaDAOImpl implements CategoriaProblemaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final CategoriaProblema categoriaProblema) throws DAOException {

		try {
			this.em.persist(categoriaProblema);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<CategoriaProblema> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from CategoriaProblema i";
			final Query query = this.em.createQuery(jpql, CategoriaProblema.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final CategoriaProblema categoriaProblema) throws DAOException {

		try {
			this.em.merge(categoriaProblema);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final CategoriaProblema categoriaProblema) throws DAOException {

		try {
			final String jpql = "delete from CategoriaProblema where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", categoriaProblema.getId());
			query.executeUpdate();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	public EntityManager getEm() {

		return this.em;
	}

	public void setEm(final EntityManager em) {

		this.em = em;
	}

	@Override
	public CategoriaProblema buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from CategoriaProblema i where i.id = :id";
			final Query query = this.em.createQuery(jpql, CategoriaProblema.class);
			query.setParameter("id", id);
			return (CategoriaProblema) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
