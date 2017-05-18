package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaCliente;

@Local
public interface CategoriaClienteDAO{

	public void criar(final CategoriaCliente categoriaCliente) throws DAOException;

	public Collection<CategoriaCliente> buscarTodos() throws DAOException;

	public void atualizar(final CategoriaCliente categoriaCliente) throws DAOException;

	public void deletar(final CategoriaCliente categoriaCliente) throws DAOException;

	public CategoriaCliente buscar(final Long id) throws DAOException;

}
