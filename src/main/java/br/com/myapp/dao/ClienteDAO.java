package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;

@Local
public interface ClienteDAO {

	public void criar(final Cliente cliente) throws DAOException;

	public Collection<Cliente> buscarTodos() throws DAOException;

	public void atualizar(final Cliente cliente) throws DAOException;

	public void deletar(final Cliente cliente) throws DAOException;

	public Cliente buscar(final Long id) throws DAOException;

}
