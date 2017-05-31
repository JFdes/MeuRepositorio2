package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.SetorDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Setor;

@Stateless
public class SetorDAOImpl implements SetorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Setor setor) throws DAOException {

		try {
			this.em.persist(setor);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Setor> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from SETOR i";
			final Query query = this.em.createQuery(jpql, Setor.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Setor setor) throws DAOException {

		try {
			this.em.merge(setor);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Setor setor) throws DAOException {

		try {
			final String jpql = "delete from SETOR where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", setor.getId());
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
	public Setor buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from SETOR i where i.id = :id";
			final Query query = this.em.createQuery(jpql, Setor.class);
			query.setParameter("id", id);
			return (Setor) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
