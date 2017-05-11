package br.com.myapp.service;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Integrante;

@Local
public interface IntegranteService {

	public void criar(final Integrante integrante) throws BusinessException;

	public Collection<Integrante> buscarTodos() throws BusinessException;

	public void atualizar(final Integrante integrante) throws BusinessException;

	public void deletar(final Integrante integrante) throws BusinessException;

	public Integrante buscar(final Long id) throws BusinessException;

}
