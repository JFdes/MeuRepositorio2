package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Integrante;

@Local
public interface IntegranteDAO {

	public void criar(final Integrante integrante) throws DAOException;

	public Collection<Integrante> buscarTodos() throws DAOException;

	public void atualizar(final Integrante integrante) throws DAOException;

	public void deletar(final Integrante integrante) throws DAOException;

	public Integrante buscar(final Long id) throws DAOException;

}
