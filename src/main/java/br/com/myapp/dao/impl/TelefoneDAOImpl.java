package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.TelefoneDAO;
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

}
