package br.com.myapp.dao;

import java.util.Collection;

import br.com.myapp.exception.DAOException;

public interface GenericDAO<T, K> {

	public void criar(final T objeto) throws DAOException;

	public void deletar(final K id) throws DAOException;

	public void atualizar(final T objeto) throws DAOException;

	public T buscarById(final K id) throws DAOException;

	public Collection<T> buscarTodos() throws DAOException;

}
