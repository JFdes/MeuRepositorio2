package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.model.Telefone;

@Local
public interface TelefoneDAO extends GenericDAO<Telefone, Long> {

}
