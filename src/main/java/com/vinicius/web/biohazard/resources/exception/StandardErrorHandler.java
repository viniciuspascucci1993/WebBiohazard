package com.vinicius.web.biohazard.resources.exception;

/**
 * Classe responsável por ser um manipulador de errors.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class StandardErrorHandler {

	/**
	 * Represents the time that was captured the exception.
	 */
	private Long timeStamp;
	
	/**
	 * Represents the status code.
	 */
	private Integer status;
	
	/**
	 * Represents de error.
	 */
	private String error;

	/**
	 * Constructor from superClasse
	 */
	public StandardErrorHandler() {
		super();
	}

	/**
	 * Constructor using fields.
	 * @param timeStamp - Long - timeStamp.
	 * @param status - Integer - statusCode.
	 * @param error - String - error name.
	 */
	public StandardErrorHandler(Long timeStamp, Integer status, String error) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
	}

	/**
	 * get() method.
	 * @return timeStamp.
	 */
	public Long getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * set() method.
	 * @param timeStamp as param.
	 */
	public void setTimeStamp(final Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * get() method.
	 * @return status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * set() method.
	 * @param status as param.
	 */
	public void setStatus(final Integer status) {
		this.status = status;
	}

	/**
	 * get() method.
	 * @return error.
	 */
	public String getError() {
		return this.error;
	}

	/**
	 * set() method.
	 * @param error as param.
	 */
	public void setError(final String error) {
		this.error = error;
	}
}
