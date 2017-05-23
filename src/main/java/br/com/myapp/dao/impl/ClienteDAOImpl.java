package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.ClienteDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;

@Stateless
public class ClienteDAOImpl implements ClienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Cliente cliente) throws DAOException {

		try {
			this.em.persist(cliente);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cliente> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from Cliente i";
			final Query query = this.em.createQuery(jpql, Cliente.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Cliente cliente) throws DAOException {

		try {
			this.em.merge(cliente);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Cliente cliente) throws DAOException {

		try {
			final String jpql = "delete from Cliente where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", cliente.getId());
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
	public Cliente buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from Cliente i where i.id = :id";
			final Query query = this.em.createQuery(jpql, Cliente.class);
			query.setParameter("id", id);
			return (Cliente) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
