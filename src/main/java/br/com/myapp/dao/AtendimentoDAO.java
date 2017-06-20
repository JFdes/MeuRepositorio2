package br.com.myapp.dao;

import java.util.Collection;

import javax.ejb.Local;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Atendimento;
import br.com.myapp.model.Ciclo;
import br.com.myapp.model.Cliente;

@Local
public interface AtendimentoDAO extends GenericDAO<Atendimento, Long> {

	public Collection<Atendimento> buscarByClienteCiclo(final Cliente cliente, final Ciclo ciclo) throws BusinessException;
}
