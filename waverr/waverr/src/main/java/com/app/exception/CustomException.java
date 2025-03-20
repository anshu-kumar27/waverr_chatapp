package com.app.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private final int errorCode;
	
	public CustomException(String message,int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
