package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.ClienteDAO;
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

}
