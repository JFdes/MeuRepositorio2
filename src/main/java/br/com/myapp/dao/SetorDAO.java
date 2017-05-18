package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Setor;

@Local
public interface SetorDAO {

	public void criar(final Setor setor) throws DAOException;

	public Collection<Setor> buscarTodos() throws DAOException;

	public void atualizar(final Setor setor) throws DAOException;

	public void deletar(final Setor setor) throws DAOException;

	public Setor buscar(final Long id) throws DAOException;

}
