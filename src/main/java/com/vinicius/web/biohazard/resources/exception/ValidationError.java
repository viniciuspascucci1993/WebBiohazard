package com.vinicius.web.biohazard.resources.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por ser um manipulador de errors.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class ValidationError extends StandardErrorHandler {
	
	
	/**
	 * Represents a list of errors
	 */
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timeStamp, Integer status, String error) {
		super(timeStamp, status, error);
		// TODO Auto-generated constructor stub
	}

	/**
	 * get() method.
	 * @return list of errors.
	 */
	public List<FieldMessage> getErrors() {
		return this.errors;
	}

	
	/**
	 * addErrors.
	 * @param fieldName
	 * @param message
	 */
	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

	
}
