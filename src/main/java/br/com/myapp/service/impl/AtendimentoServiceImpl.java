package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.AtendimentoDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Atendimento;
import br.com.myapp.model.Ciclo;
import br.com.myapp.model.Cliente;
import br.com.myapp.service.AtendimentoService;

@Stateless
public class AtendimentoServiceImpl implements AtendimentoService {

	@EJB
	private AtendimentoDAO dao;

	@Override
	public void criar(final Atendimento atendimento) throws BusinessException {

		this.dao.criar(atendimento);
	}

	@Override
	public Collection<Atendimento> buscarByClienteCiclo(final Cliente cliente, final Ciclo ciclo) throws BusinessException {

		return this.dao.buscarByClienteCiclo(cliente, ciclo);
	}

}
