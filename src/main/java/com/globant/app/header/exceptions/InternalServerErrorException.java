package com.globant.app.header.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
/**
 * 
 * @author srcortes
 *
 */
@Data
public class InternalServerErrorException extends Exception{	
	private static final long serialVersionUID = 9152533042475506072L;
	private HttpStatus status;
	public InternalServerErrorException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}
	public InternalServerErrorException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}	
}
