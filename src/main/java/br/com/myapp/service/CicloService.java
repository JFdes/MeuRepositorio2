package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Ciclo;

@Local
public interface CicloService {

	public void criar(final Ciclo ciclo) throws BusinessException;

	public Collection<Ciclo> buscarTodos() throws BusinessException;

	public void atualizar(final Ciclo ciclo) throws BusinessException;

	public void deletar(final Ciclo ciclo) throws BusinessException;

	public Ciclo buscar(final Long id) throws BusinessException;

}
