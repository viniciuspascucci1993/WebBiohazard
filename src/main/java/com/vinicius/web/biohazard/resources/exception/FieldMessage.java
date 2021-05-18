package com.vinicius.web.biohazard.resources.exception;

import java.io.Serializable;

/**
 * Classe responsável por ser um manipulador de errors.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class FieldMessage implements Serializable{

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the field name.
	 */
	private String fieldName;
	
	/**
	 * Represents the message.
	 */
	private String message;
	
	/**
	 * Empty Constructor.
	 */
	public FieldMessage() { }

	/**
	 * Constructor using fields.
	 * @param fieldName
	 * @param message
	 */
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	/**
	 * get() method.
	 * @return fieldName.
	 */
	public String getFieldName() {
		return this.fieldName;
	}

	/**
	 * set() method.
	 * @param fieldName as param
	 */
	public void setFieldName(final String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * get() method.
	 * @return message.
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * set() method.
	 * @param message as param.
	 */
	public void setMessage(final String message) {
		this.message = message;
	}
}


