package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.ClienteDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Cliente;

@Stateless
public class ClienteDAOImpl extends AbstractGenericDAO<Cliente, Long> implements ClienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Cliente> getEntityClass() {

		return Cliente.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cliente> buscarByCategoriaCliente(final CategoriaCliente categoriaCliente) throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select c from Cliente c ");
			jpql.append(" where c.categoria = :categoria ");

			final Query query = this.em.createQuery(jpql.toString(), this.getEntityClass());
			query.setParameter("categoria", categoriaCliente);

			return query.getResultList() != null ? query.getResultList() : null;
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
