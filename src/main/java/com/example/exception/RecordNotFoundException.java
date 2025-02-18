package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public RecordNotFoundException(Integer id){
		super("Employee id not found : "+id);
	}
}
