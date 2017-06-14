package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Funcionario;

@Local
public interface FuncionarioService {

	public void criar(final Funcionario funcionario) throws BusinessException;

	public Collection<Funcionario> buscarTodos() throws BusinessException;

	public void atualizar(final Funcionario funcionario) throws BusinessException;

	public void deletar(final Funcionario funcionario) throws BusinessException;

	public Funcionario buscar(final Long id) throws BusinessException;

	public Funcionario buscar(final String usuario, final String senha) throws BusinessException;

}
