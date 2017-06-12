package br.com.myapp.exception;

public class CampoInvalidoException extends BusinessException {

	private static final long serialVersionUID = -2134013758419697334L;

	public CampoInvalidoException(final String campo) {
		super(String.format("O campo %s não pode estar vazio.", campo));
	}

}
