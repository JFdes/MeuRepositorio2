package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.CategoriaProblemaDAO;
import br.com.myapp.model.CategoriaProblema;

@Stateless
public class CategoriaProblemaDAOImpl extends AbstractGenericDAO<CategoriaProblema, Long> implements CategoriaProblemaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<CategoriaProblema> getEntityClass() {

		return CategoriaProblema.class;
	}

}
