package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Setor;

@Local
public interface SetorService {

	public void criar(final Setor setor) throws BusinessException;

	public Collection<Setor> buscarTodos() throws BusinessException;

	public void atualizar(final Setor setor) throws BusinessException;

	public void deletar(final Setor setor) throws BusinessException;

	public Setor buscar(final Long id) throws BusinessException;

}
