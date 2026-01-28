package com.info.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {
		e.printStackTrace();
		return ResponseEntity.internalServerError().body("opps!! something went wrong");
	}
	@ExceptionHandler(BookNotFoundException.class)
	  public ResponseEntity<String> globalException(BookNotFoundException e){
		  return ResponseEntity.status(404).body(e.getMessage());
	  }
	@ExceptionHandler(BookAlreadyExistException.class)
	public ResponseEntity<String> globalException(BookAlreadyExistException e){
		  return ResponseEntity.status(404).body(e.getMessage());
	  }
}
