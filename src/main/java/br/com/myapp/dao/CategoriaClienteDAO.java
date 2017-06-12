package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.model.CategoriaCliente;

@Local
public interface CategoriaClienteDAO extends GenericDAO<CategoriaCliente, Long> {

}
