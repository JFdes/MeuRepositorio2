package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Telefone;

@Local
public interface TelefoneService {

	public void criar(final Telefone telefone) throws BusinessException;

	public Collection<Telefone> buscarTodos() throws BusinessException;

	public void atualizar(final Telefone telefone) throws BusinessException;

	public void deletar(final Telefone telefone) throws BusinessException;

	public Telefone buscar(final Long id) throws BusinessException;

}
