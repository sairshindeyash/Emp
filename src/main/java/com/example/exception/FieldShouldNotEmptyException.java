package com.example.exception;

public class FieldShouldNotEmptyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public FieldShouldNotEmptyException(String message) {
		super(message);
	}
   
}
