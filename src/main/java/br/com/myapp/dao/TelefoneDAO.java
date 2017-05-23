package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Telefone;

@Local
public interface TelefoneDAO{

	public void criar(final Telefone telefone) throws DAOException;

	public Collection<Telefone> buscarTodos() throws DAOException;

	public void atualizar(final Telefone telefone) throws DAOException;

	public void deletar(final Telefone telefone) throws DAOException;

	public Telefone buscar(final Long id) throws DAOException;

}
