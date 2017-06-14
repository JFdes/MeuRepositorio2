package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.FuncionarioDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Funcionario;

@Stateless
public class FuncionarioDAOImpl extends AbstractGenericDAO<Funcionario, Long> implements FuncionarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Funcionario> getEntityClass() {

		return Funcionario.class;
	}

	@Override
	public Funcionario buscar(final String usuario, final String senha) throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select f from Funcionario f ");
			jpql.append(" where f.usuario = :usuario ");
			jpql.append(" and f.senha = :senha ");

			final Query query = this.em.createQuery(jpql.toString(), this.getEntityClass());
			query.setParameter("usuario", usuario);
			query.setParameter("senha", senha);

			return query.getSingleResult() != null ? ((Funcionario) query.getSingleResult()) : null;
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
