package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.CicloDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Ciclo;

@Stateless
public class CicloDAOImpl implements CicloDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Ciclo ciclo) throws DAOException {

		try {
			this.em.persist(ciclo);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Ciclo> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from CICLO i";
			final Query query = this.em.createQuery(jpql, Ciclo.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Ciclo ciclo) throws DAOException {

		try {
			this.em.merge(ciclo);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Ciclo ciclo) throws DAOException {

		try {
			final String jpql = "delete from Ciclo where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", ciclo.getId());
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
	public Ciclo buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from CICLO i where i.id = :id";
			final Query query = this.em.createQuery(jpql, Ciclo.class);
			query.setParameter("id", id);
			return (Ciclo) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
