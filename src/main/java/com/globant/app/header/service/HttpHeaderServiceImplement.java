package com.globant.app.header.service;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.globant.app.header.exceptions.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
@Service
@Primary
@Slf4j
public class HttpHeaderServiceImplement implements HttpHeaderService {
	@Autowired
	HttpServletRequest request;
	@Override
	public Map<String, List<String>> listHeader() throws InternalServerErrorException{
		try {
		 Map<String, List<String>> map = new HashMap<>();	
		 Collections.list(request.getHeaderNames()).stream().forEach(i->{			
			 String [] a = request.getHeaders(i).nextElement().split(",");
			 List<String> lista = Arrays.asList(a);
			 map.put(i,lista);
		 }); 
		System.out.println(map); 
		return map;
		}catch (Exception ex) {
			throw new InternalServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error getting header", ex);
		}		
	}	
}
