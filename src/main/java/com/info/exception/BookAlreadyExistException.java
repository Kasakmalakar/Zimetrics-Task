package com.info.exception;

public class BookAlreadyExistException extends RuntimeException {
       public BookAlreadyExistException(String msg) {
    	   super(msg);
       }
}
