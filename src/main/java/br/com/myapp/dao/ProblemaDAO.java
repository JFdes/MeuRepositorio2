package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Problema;

@Local
public interface ProblemaDAO {

	public void criar(final Problema problema) throws DAOException;

	public Collection<Problema> buscarTodos() throws DAOException;

	public void atualizar(final Problema problema) throws DAOException;

	public void deletar(final Problema problema) throws DAOException;

	public Problema buscar(final Long id) throws DAOException;

}
