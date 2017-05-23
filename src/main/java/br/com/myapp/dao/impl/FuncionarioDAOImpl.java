package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.FuncionarioDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Funcionario;

@Stateless
public class FuncionarioDAOImpl implements FuncionarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void criar(final Funcionario funcionario) throws DAOException {

		try {
			this.em.persist(funcionario);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Funcionario> buscarTodos() throws DAOException {

		try {
			final String jpql = "select i from Funcionario i";
			final Query query = this.em.createQuery(jpql, Funcionario.class);
			return query.getResultList();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void atualizar(final Funcionario funcionario) throws DAOException {

		try {
			this.em.merge(funcionario);
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletar(final Funcionario funcionario) throws DAOException {

		try {
			final String jpql = "delete from Funcionario where id = :id";
			final Query query = this.em.createQuery(jpql);
			query.setParameter("id", funcionario.getId());
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
	public Funcionario buscar(final Long id) throws DAOException {

		try {
			final String jpql = "select i from Funcionario i where i.id = :id";
			final Query query = this.em.createQuery(jpql, Funcionario.class);
			query.setParameter("id", id);
			return (Funcionario) query.getSingleResult();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
