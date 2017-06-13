package br.com.myapp.service.impl;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.myapp.dao.TelefoneDAO;
import br.com.myapp.exception.BusinessException;
import br.com.myapp.exception.DAOException;
import br.com.myapp.model.Cliente;
import br.com.myapp.model.Telefone;
import br.com.myapp.service.TelefoneService;

@Stateless
public class TelefoneServiceImpl implements TelefoneService {

	@EJB
	private TelefoneDAO dao;

	@Override
	public void criar(final Collection<Telefone> telefones, final Cliente cliente) throws BusinessException {

		try {

			this.removerTelefonesVinculados(cliente);

			if (telefones != null) {

				for (final Telefone telefone : telefones) {

					telefone.setCliente(cliente);

					this.dao.criar(telefone);
				}
			}
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Collection<Telefone> buscarTodos() throws BusinessException {

		try {

			return this.dao.buscarTodos();
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void atualizar(final Telefone telefone) throws BusinessException {

		try {

			this.dao.atualizar(telefone);
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void deletar(final Telefone telefone) throws BusinessException {

		try {

			this.dao.deletar(telefone.getId());
		} catch (final DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Telefone buscar(final Long id) throws BusinessException {

		return this.dao.buscarById(id);
	}

	@Override
	public Collection<Telefone> buscarByCliente(final Cliente cliente) throws BusinessException {

		return this.dao.buscarByCliente(cliente);
	}

	public void removerTelefonesVinculados(final Cliente cliente) throws BusinessException {

		this.dao.deletarByCliente(cliente);
	}

}
