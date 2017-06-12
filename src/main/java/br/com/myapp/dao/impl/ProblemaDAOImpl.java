package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.ProblemaDAO;
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

}
