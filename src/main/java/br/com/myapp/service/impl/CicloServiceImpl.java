package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.CicloDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Ciclo;
import br.com.myapp.service.CicloService;

@Stateless
public class CicloServiceImpl implements CicloService {

	@EJB
	private CicloDAO dao;

	@Override
	public void criar(final Ciclo ciclo) throws BusinessException {

		try {

			if(ciclo.getId()==null){
				this.dao.criar(ciclo);
			} else {
				this.atualizar(ciclo);
			}
			
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Ciclo> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Ciclo ciclo) throws BusinessException {

		try {

			this.dao.atualizar(ciclo);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Ciclo ciclo) throws BusinessException {

		try {

			this.dao.deletar(ciclo);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Ciclo buscar(final Long id) throws BusinessException {

		return this.dao.buscar(id);
	}

}
