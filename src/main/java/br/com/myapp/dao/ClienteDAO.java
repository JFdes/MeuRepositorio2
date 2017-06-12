package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.model.Cliente;

@Local
public interface ClienteDAO extends GenericDAO<Cliente, Long> {

}
