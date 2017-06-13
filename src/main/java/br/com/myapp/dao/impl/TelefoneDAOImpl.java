package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.TelefoneDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Telefone;

@Stateless
public class TelefoneDAOImpl extends AbstractGenericDAO<Telefone, Long> implements TelefoneDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Telefone> getEntityClass() {

		return Telefone.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Telefone> buscarByCliente(final Cliente cliente) throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select t from Telefone t ");
			jpql.append(" where t.cliente = :cliente ");

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
			jpql.append(" delete from Telefone t ");
			jpql.append(" where t.cliente = :cliente ");

			final Query query = this.em.createQuery(jpql.toString());
			query.setParameter("cliente", cliente);

			query.executeUpdate();
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
