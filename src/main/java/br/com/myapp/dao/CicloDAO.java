package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Ciclo;

@Local
public interface CicloDAO {

	public void criar(final Ciclo ciclo) throws DAOException;

	public Collection<Ciclo> buscarTodos() throws DAOException;

	public void atualizar(final Ciclo ciclo) throws DAOException;

	public void deletar(final Ciclo ciclo) throws DAOException;

	public Ciclo buscar(final Long id) throws DAOException;

}
