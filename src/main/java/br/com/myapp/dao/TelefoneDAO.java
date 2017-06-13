package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Telefone;

@Local
public interface TelefoneDAO extends GenericDAO<Telefone, Long> {

	public Collection<Telefone> buscarByCliente(final Cliente cliente) throws DAOException;

	public void deletarByCliente(final Cliente cliente) throws DAOException;

}
