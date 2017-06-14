package br.com.myapp.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Atendimento;

@ViewScoped
@ManagedBean
public class AtendimentoMB extends AbstractManagedBean<Atendimento> {

	@PostConstruct
	@Override
	public void init() {

		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void limpar() {

		// TODO Auto-generated method stub

	}

	@Override
	public void popularInterface() throws BusinessException {

		// TODO Auto-generated method stub

	}

	@Override
	public void popularCampos(final Atendimento object) throws BusinessException {

		// TODO Auto-generated method stub

	}

	@Override
	public void popularObjeto(final Atendimento object) {

		// TODO Auto-generated method stub

	}

	@Override
	public void validarCampos() throws BusinessException {

		// TODO Auto-generated method stub

	}

	@Override
	public void salvar(final Atendimento object) throws BusinessException {

		// TODO Auto-generated method stub

	}

	@Override
	public void editar() {

		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(final Atendimento itemSelecionado) throws BusinessException {

		// TODO Auto-generated method stub

	}

	@Override
	public Class<Atendimento> getObjectClass() {

		// TODO Auto-generated method stub
		return null;
	}

}
