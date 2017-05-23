package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.CategoriaProblema;

@Local
public interface CategoriaProblemaService {

	public void criar(final CategoriaProblema categoriaProblema) throws BusinessException;

	public Collection<CategoriaProblema> buscarTodos() throws BusinessException;

	public void atualizar(final CategoriaProblema categoriaProblema) throws BusinessException;

	public void deletar(final CategoriaProblema categoriaProblema) throws BusinessException;

	public CategoriaProblema buscar(final Long id) throws BusinessException;

}
