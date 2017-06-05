package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.TelefoneDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Telefone;

@Stateless
public class TelefoneDAOImpl implements TelefoneDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Telefone telefone) throws DAOException {

		try {
			this.em.persist(telefone);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Telefone> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from TELEFONE i order by i.idCliente";
			final Query query = this.em.createQuery(jpql, Telefone.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Telefone telefone) throws DAOException {

		try {
			this.em.merge(telefone);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Telefone telefone) throws DAOException {

		try {
			final String jpql = "delete from TELEFONE where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", telefone.getId());
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
	public Telefone buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from TELEFONE i where i.id = :id";
			final Query query = this.em.createQuery(jpql, Telefone.class);
			query.setParameter("id", id);
			return (Telefone) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
