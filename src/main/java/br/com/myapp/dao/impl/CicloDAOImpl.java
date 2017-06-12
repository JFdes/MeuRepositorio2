package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.CicloDAO;
import br.com.myapp.model.Ciclo;

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

}
