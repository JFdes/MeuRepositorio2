package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.CategoriaClienteDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaCliente;

@Stateless
public class CategoriaClienteDAOImpl implements CategoriaClienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final CategoriaCliente categoriaCliente) throws DAOException {

		try {
			this.em.persist(categoriaCliente);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<CategoriaCliente> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from Integrante i";
			final Query query = this.em.createQuery(jpql, CategoriaCliente.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final CategoriaCliente categoriaCliente) throws DAOException {

		try {
			this.em.merge(categoriaCliente);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final CategoriaCliente categoriaCliente) throws DAOException {

		try {
			final String jpql = "delete from Integrante where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", categoriaCliente.getId());
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
	public CategoriaCliente buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from Integrante i where i.id = :id";
			final Query query = this.em.createQuery(jpql, CategoriaCliente.class);
			query.setParameter("id", id);
			return (CategoriaCliente) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
