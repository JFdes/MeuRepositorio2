package br.com.myapp.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.myapp.dao.FuncionarioDAO;
import br.com.myapp.model.Funcionario;

@Stateless
public class FuncionarioDAOImpl extends AbstractGenericDAO<Funcionario, Long> implements FuncionarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {

		return this.em;
	}

	@Override
	protected Class<Funcionario> getEntityClass() {

		return Funcionario.class;
	}

}
