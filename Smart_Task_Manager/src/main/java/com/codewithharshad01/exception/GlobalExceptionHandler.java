package com.codewithharshad01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {

		ErrorResponse error = new ErrorResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {

	    ErrorResponse error = new ErrorResponse(
	            ex.getMessage(),
	            HttpStatus.NOT_FOUND.value()
	    );

	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

	    String errorMsg = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(error -> error.getField() + ": " + error.getDefaultMessage())
	            .findFirst()
	            .orElse("Validation error");

	    ErrorResponse error = new ErrorResponse(
	            errorMsg,
	            HttpStatus.BAD_REQUEST.value()
	    );

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}