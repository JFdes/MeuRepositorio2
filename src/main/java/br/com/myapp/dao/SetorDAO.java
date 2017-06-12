package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.model.Setor;

@Local
public interface SetorDAO extends GenericDAO<Setor, Long> {

}
