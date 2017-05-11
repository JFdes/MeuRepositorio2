package br.com.myapp.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 7475364053296975361L;

	public BusinessException(final String message) {
		super(message);
	}

	public BusinessException(final Throwable e) {
		super(e);
	}

	public BusinessException(final String message, final Throwable e) {
		super(message, e);
	}

}
