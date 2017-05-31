package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.ProblemaDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Problema;

@Stateless
public class ProblemaDAOImpl implements ProblemaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Problema problema) throws DAOException {

		try {
			this.em.persist(problema);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Problema> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from PROBLEMA i";
			final Query query = this.em.createQuery(jpql, Problema.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Problema problema) throws DAOException {

		try {
			this.em.merge(problema);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Problema problema) throws DAOException {

		try {
			final String jpql = "delete from PROBLEMA where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", problema.getId());
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
	public Problema buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from PROBLEMA i where i.id = :id";
			final Query query = this.em.createQuery(jpql, Problema.class);
			query.setParameter("id", id);
			return (Problema) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
