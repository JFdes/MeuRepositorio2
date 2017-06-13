package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Cliente;

@Local
public interface ClienteDAO extends GenericDAO<Cliente, Long> {

	public Collection<Cliente> buscarByCategoriaCliente(CategoriaCliente categoriaCliente) throws DAOException;
}
