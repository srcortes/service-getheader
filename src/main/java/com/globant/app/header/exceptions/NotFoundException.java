package com.globant.app.header.exceptions;

import org.springframework.http.HttpStatus;
import lombok.Data;
/**
 * 
 * @author srcortes
 *
 */
@Data
public class NotFoundException extends Exception {
	private HttpStatus status;	
	private static final long serialVersionUID = 1L;
	public NotFoundException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}
	public NotFoundException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}	
}