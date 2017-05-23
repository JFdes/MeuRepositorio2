package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.ProblemaDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Problema;
import br.com.myapp.service.ProblemaService;

@Stateless
public class ProblemaServiceImpl implements ProblemaService {

	@EJB
	private ProblemaDAO dao;

	@Override
	public void criar(final Problema problema) throws BusinessException {

		try {

			if(problema.id==null){
				this.dao.criar(problema);
			}
			else
				atualizar(problema);
			
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Problema> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Problema problema) throws BusinessException {

		try {

			this.dao.atualizar(problema);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Problema problema) throws BusinessException {

		try {

			this.dao.deletar(problema);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Problema buscar(final Long id) throws BusinessException {

		return this.dao.buscar(id);
	}

}
