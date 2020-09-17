package com.company.bma.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.company.bma.model.ApiError;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class GlobalControllerExceptionHandler{
	
  @ExceptionHandler(value=ConstraintViolationException.class)
  private ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request){
	  return null;
  }
  
  @ExceptionHandler(value=Generic401Exception.class)
  private ResponseEntity<ApiError> handleGeneric401Exception(Generic401Exception ex, WebRequest request){
	  log.error("Invalid request---"+request.getContextPath());
	  return new ResponseEntity<ApiError>(new ApiError(ex.getMessage(),ex.getDescription()),HttpStatus.UNAUTHORIZED) ;
  }
  
  @ExceptionHandler(value=Generic403Exception.class)
  private ResponseEntity<ApiError> handleGeneric403Exception(Generic403Exception ex, WebRequest request){
	  log.error("Invalid request---"+request.getContextPath());
	  return new ResponseEntity<ApiError>(new ApiError(ex.getMessage(),ex.getDescription()),HttpStatus.FORBIDDEN) ;
  }
  
  @ExceptionHandler(value=Generic404Exception.class)
  private ResponseEntity<ApiError> handleGeneric404Exception(Generic404Exception ex, WebRequest request){
	  log.error("Invalid request---"+request.getContextPath());
	  return new ResponseEntity<ApiError>(new ApiError(ex.getMessage(),ex.getDescription()),HttpStatus.NOT_FOUND) ;
  }
  
  @ExceptionHandler(value=Generic406Exception.class)
  private ResponseEntity<ApiError> handleGeneric406Exception(Generic406Exception ex, WebRequest request){
	  log.error("Invalid request---"+request.getContextPath());
	  return new ResponseEntity<ApiError>(new ApiError(ex.getMessage(),ex.getDescription()),HttpStatus.NOT_ACCEPTABLE) ;
  }
}
