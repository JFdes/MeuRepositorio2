package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaProblema;

@Local
public interface CategoriaProblemaDAO {

	public void criar(final CategoriaProblema categoriaProblema) throws DAOException;

	public Collection<CategoriaProblema> buscarTodos() throws DAOException;

	public void atualizar(final CategoriaProblema categoriaProblema) throws DAOException;

	public void deletar(final CategoriaProblema categoriaProblema) throws DAOException;

	public CategoriaProblema buscar(final Long id) throws DAOException;

}
