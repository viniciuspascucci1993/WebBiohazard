package com.vinicius.web.biohazard.resources.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vinicius.web.biohazard.service.exception.ObjectNotFoundException;

/**
 * Classe responsável por ser um manipulador de erros de resource..
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErrorHandler> objectNotFoundExcption( ObjectNotFoundException e, ServletRequest servletRequest ) {
		
		StandardErrorHandler standardErrorHandler = new StandardErrorHandler(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardErrorHandler);
	}
}
