package com.globant.app.header.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/**
 * 
 * @author srcortes
 *
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler {
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<Object> customHandleNotFound(final Exception ex, WebRequest request) {
		InternalServerErrorException finEx = (InternalServerErrorException) ex;
		ApiError apiError = new ApiError(finEx.getStatus(), "Is present errors service", ex.getMessage());
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
