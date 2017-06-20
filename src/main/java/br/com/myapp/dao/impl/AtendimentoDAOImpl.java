package br.com.myapp.dao.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.myapp.dao.AtendimentoDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Atendimento;
import br.com.myapp.model.Ciclo;
import br.com.myapp.model.Cliente;

@Stateless
public class AtendimentoDAOImpl extends AbstractGenericDAO<Atendimento, Long> implements AtendimentoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Atendimento> getEntityClass() {

		return Atendimento.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Atendimento> buscarByClienteCiclo(final Cliente cliente, final Ciclo ciclo) throws BusinessException {

		try {

			final StringBuilder jpql = new StringBuilder();
			jpql.append(" select a from Atendimento a ");
			jpql.append(" where a.cliente.id = :cliente ");
			jpql.append(" and a.ciclo.id = :ciclo");

			final Query query = this.em.createQuery(jpql.toString(), this.getEntityClass());
			query.setParameter("cliente", cliente.getId());
			query.setParameter("ciclo", ciclo.getId());

			return query.getResultList() != null ? query.getResultList() : null;
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			throw new DAOException(e);
		}
	}

}
