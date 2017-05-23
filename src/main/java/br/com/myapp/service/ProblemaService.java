package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Problema;

@Local
public interface ProblemaService {

	public void criar(final Problema problema) throws BusinessException;

	public Collection<Problema> buscarTodos() throws BusinessException;

	public void atualizar(final Problema problema) throws BusinessException;

	public void deletar(final Problema problema) throws BusinessException;

	public Problema buscar(final Long id) throws BusinessException;

}
