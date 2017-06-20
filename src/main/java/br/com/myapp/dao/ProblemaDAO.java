package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Problema;

@Local
public interface ProblemaDAO extends GenericDAO<Problema, Long> {

	public Collection<Problema> buscarByCliente(Cliente cliente) throws DAOException;

	public void deletarByCliente(Cliente cliente) throws DAOException;

	public Collection<Problema> buscarProblemasAbertosByCliente(final Cliente cliente) throws DAOException;
}
