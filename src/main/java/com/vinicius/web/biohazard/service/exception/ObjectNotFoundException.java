package com.vinicius.web.biohazard.service.exception;

/**
 * classe personalizada para tratar erros de objeto não encontrado.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

	
}
