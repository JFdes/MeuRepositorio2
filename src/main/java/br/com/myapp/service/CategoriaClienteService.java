package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.CategoriaCliente;

@Local
public interface CategoriaClienteService {

	public void criar(final CategoriaCliente categoriaCliente) throws BusinessException;

	public Collection<CategoriaCliente> buscarTodos() throws BusinessException;

	public void atualizar(final CategoriaCliente categoriaCliente) throws BusinessException;

	public void deletar(final CategoriaCliente categoriaCliente) throws BusinessException;

	public CategoriaCliente buscar(final Long id) throws BusinessException;

}
