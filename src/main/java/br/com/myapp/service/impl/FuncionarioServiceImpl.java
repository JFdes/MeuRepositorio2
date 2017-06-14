package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.FuncionarioDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Funcionario;
import br.com.myapp.service.FuncionarioService;

@Stateless
public class FuncionarioServiceImpl implements FuncionarioService {

	@EJB
	private FuncionarioDAO dao;

	@Override
	public void criar(final Funcionario funcionario) throws BusinessException {

		try {

			if (funcionario.getId() == null) {
				this.dao.criar(funcionario);
			} else {
				this.dao.atualizar(funcionario);
			}

		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Funcionario> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Funcionario funcionario) throws BusinessException {

		try {

			this.dao.atualizar(funcionario);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Funcionario funcionario) throws BusinessException {

		try {

			this.dao.deletar(funcionario.getId());
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Funcionario buscar(final Long id) throws BusinessException {

		return this.dao.buscarById(id);
	}

	@Override
	public Funcionario buscar(final String usuario, final String senha) throws BusinessException {

		return this.dao.buscar(usuario, senha);
	}

}
