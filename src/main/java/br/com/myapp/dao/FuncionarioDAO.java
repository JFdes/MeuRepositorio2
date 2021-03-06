package br.com.myapp.dao;

import javax.ejb.Local;

import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Funcionario;

@Local
public interface FuncionarioDAO extends GenericDAO<Funcionario, Long> {

	public Funcionario buscar(String usuario, String senha) throws DAOException;
}
