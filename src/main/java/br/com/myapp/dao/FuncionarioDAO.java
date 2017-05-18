package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Funcionario;

@Local
public interface FuncionarioDAO {

	public void criar(final Funcionario funcionario) throws DAOException;

	public Collection<Funcionario> buscarTodos() throws DAOException;

	public void atualizar(final Funcionario funcionario) throws DAOException;

	public void deletar(final Funcionario funcionario) throws DAOException;

	public Funcionario buscar(final Long id) throws DAOException;

}
