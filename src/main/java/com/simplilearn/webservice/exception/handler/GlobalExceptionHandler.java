package com.simplilearn.webservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductAlreadyExist;
import com.simplilearn.webservice.exception.ProductNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	// Product Not Found Exception
	@ExceptionHandler(value = ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> notFoundException(ProductNotFound ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	// Product Already Exist Exception
	@ExceptionHandler(value = ProductAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> alreadExistException(ProductAlreadyExist ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	// Product Already Exist Exception
	@ExceptionHandler(value = InvalidProductException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidProductException ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
