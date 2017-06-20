package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.ProblemaDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Problema;

@Stateless
public class ProblemaDAOImpl extends AbstractGenericDAO<Problema, Long> implements ProblemaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Problema> getEntityClass() {

		return Problema.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Problema> buscarByCliente(final Cliente cliente) throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select p from Problema p ");
			jpql.append(" where p.cliente = :cliente ");

			final Query query = this.em.createQuery(jpql.toString(), this.getEntityClass());
			query.setParameter("cliente", cliente);

			return query.getResultList() != null ? query.getResultList() : null;
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deletarByCliente(final Cliente cliente) throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" delete from Problema p ");
			jpql.append(" where p.cliente = :cliente ");

			final Query query = this.em.createQuery(jpql.toString());
			query.setParameter("cliente", cliente);

			query.executeUpdate();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Problema> buscarProblemasAbertosByCliente(final Cliente cliente) throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select p from Problema p ");
			jpql.append(" where p.cliente = :cliente ");
			jpql.append(" and p.status <> 'RESOLVIDO' ");

			final Query query = this.em.createQuery(jpql.toString(), this.getEntityClass());
			query.setParameter("cliente", cliente);

			return query.getResultList() != null ? query.getResultList() : null;
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
