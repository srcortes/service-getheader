package com.globant.app.header.service;

import java.util.List;
import java.util.Map;

import com.globant.app.header.exceptions.InternalServerErrorException;
import com.globant.app.header.exceptions.NotFoundException;
/**
 * 
 * @author srcortes
 *
 */
public interface HttpHeaderService {
	Map<String, List<String>> listHeader() throws InternalServerErrorException;
	Map<String, List<String>> listHeaderByName(List<String> headerName) throws Exception;
	
}
