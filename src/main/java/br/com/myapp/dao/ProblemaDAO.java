package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.model.Problema;

@Local
public interface ProblemaDAO extends GenericDAO<Problema, Long> {

}
