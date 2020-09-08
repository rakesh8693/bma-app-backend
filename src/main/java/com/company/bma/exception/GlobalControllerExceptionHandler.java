package com.company.bma.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
  @ExceptionHandler(value=ConstraintViolationException.class)
  private ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request){
	  return null;
  }
  
  @ExceptionHandler(value=Generic401Exception.class)
  private ResponseEntity<Object> handleGeneric401Exception(Generic401Exception ex, WebRequest request){
	  return null;
  }
  
  @ExceptionHandler(value=Generic403Exception.class)
  private ResponseEntity<Object> handleGeneric403Exception(Generic403Exception ex, WebRequest request){
	  return null;
  }
  
  @ExceptionHandler(value=Generic404Exception.class)
  private ResponseEntity<Object> handleGeneric404Exception(Generic404Exception ex, WebRequest request){
	  return null;
  }
}
