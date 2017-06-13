package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.CategoriaCliente;
import br.com.myapp.model.Cliente;

@Local
public interface ClienteService {

	public void criar(final Cliente cliente) throws BusinessException;

	public Collection<Cliente> buscarTodos() throws BusinessException;

	public void atualizar(final Cliente cliente) throws BusinessException;

	public void deletar(final Cliente cliente) throws BusinessException;

	public Cliente buscar(final Long id) throws BusinessException;

	public Collection<Cliente> buscarByCategoriaCliente(final CategoriaCliente categoriaCliente) throws BusinessException;

}
