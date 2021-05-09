package com.vinicius.web.biohazard.service.exception;

/**
 * classe personalizada para tratar erros de objeto não encontrado.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class DataIntegrityViolationException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}

}
