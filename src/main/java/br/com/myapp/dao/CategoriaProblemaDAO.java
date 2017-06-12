package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.model.CategoriaProblema;

@Local
public interface CategoriaProblemaDAO extends GenericDAO<CategoriaProblema, Long> {

}
