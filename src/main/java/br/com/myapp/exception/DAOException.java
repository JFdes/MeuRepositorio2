package br.com.myapp.exception;

public class DAOException extends BusinessException {

	private static final long serialVersionUID = -3158195330944231779L;

	public DAOException(final String message) {
		super(message);
	}

	public DAOException(final Throwable e) {
		super(e);
	}

	public DAOException(final String message, final Throwable e) {
		super(message, e);
	}

}
