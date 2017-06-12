package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.CategoriaClienteDAO;
import br.com.myapp.model.CategoriaCliente;

@Stateless
public class CategoriaClienteDAOImpl extends AbstractGenericDAO<CategoriaCliente, Long> implements CategoriaClienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<CategoriaCliente> getEntityClass() {

		return CategoriaCliente.class;
	}

}
