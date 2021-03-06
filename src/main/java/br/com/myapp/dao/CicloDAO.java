package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Ciclo;

@Local
public interface CicloDAO extends GenericDAO<Ciclo, Long> {

	public Ciclo buscarCicloAtual() throws DAOException;
}
