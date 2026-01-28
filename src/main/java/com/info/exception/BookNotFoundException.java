package com.info.exception;

public class BookNotFoundException  extends RuntimeException{
  public BookNotFoundException(String msg) {
	  super("Book not found ");
  }
}
