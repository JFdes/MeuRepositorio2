package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.TelefoneDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Telefone;
import br.com.myapp.service.TelefoneService;

@Stateless
public class TelefoneServiceImpl implements TelefoneService {

	@EJB
	private TelefoneDAO dao;

	@Override
	public void criar(final Telefone telefone) throws BusinessException {

		try {

			if(telefone.id==null){
				this.dao.criar(telefone);
			}
			else
				atualizar(telefone);
			
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Telefone> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Telefone telefone) throws BusinessException {

		try {

			this.dao.atualizar(telefone);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Telefone telefone) throws BusinessException {

		try {

			this.dao.deletar(telefone);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Telefone buscar(final Long id) throws BusinessException {

		return this.dao.buscar(id);
	}

}
