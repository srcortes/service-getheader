package com.globant.app.header.service;

import java.util.List;
import java.util.Map;

import com.globant.app.header.exceptions.InternalServerErrorException;
/**
 * 
 * @author srcortes
 *
 */
public interface HttpHeaderService {
	Map<String, List<String>> listHeader() throws InternalServerErrorException;
}
