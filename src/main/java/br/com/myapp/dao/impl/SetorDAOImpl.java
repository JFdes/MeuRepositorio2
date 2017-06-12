package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.SetorDAO;
import br.com.myapp.model.Setor;

@Stateless
public class SetorDAOImpl extends AbstractGenericDAO<Setor, Long> implements SetorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Setor> getEntityClass() {

		return Setor.class;
	}

}
