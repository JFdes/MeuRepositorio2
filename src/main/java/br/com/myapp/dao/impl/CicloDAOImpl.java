package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.CicloDAO;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Ciclo;
import br.com.myapp.util.DateUtil;

@Stateless
public class CicloDAOImpl extends AbstractGenericDAO<Ciclo, Long> implements CicloDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Ciclo> getEntityClass() {

		return Ciclo.class;
	}

	@Override
	public Ciclo buscarCicloAtual() throws DAOException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select c from Ciclo c ");
			jpql.append(" where :dataAtual between c.dataInicio and c.dataFim ");

			final Query query = this.em.createQuery(jpql.toString(), this.getEntityClass());
			query.setParameter("dataAtual", DateUtil.getCurrent());

			return query.getSingleResult() != null ? (Ciclo) query.getSingleResult() : null;
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
