package com.vinicius.web.biohazard.resources.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vinicius.web.biohazard.service.exception.DataIntegrityViolationException;
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
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardErrorHandler> dataIntegrityViolationException( DataIntegrityViolationException e, ServletRequest servletRequest ) {
		
		StandardErrorHandler standardErrorHandler = new StandardErrorHandler(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardErrorHandler);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErrorHandler> validationErrors( MethodArgumentNotValidException e, ServletRequest servletRequest ) {
		
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Your have validation errors on fields. Please review");
		
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			
			error.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
