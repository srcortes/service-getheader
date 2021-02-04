package com.globant.app.header.service;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.globant.app.header.exceptions.InternalServerErrorException;
@Service
@Primary
public class HttpHeaderServiceImplement implements HttpHeaderService {
	@Autowired
	HttpServletRequest request;
	@Override
	public Map<String, List<String>> listHeader() throws InternalServerErrorException{
		
		 Enumeration headerNames = request.getHeaderNames();
		 
		 Map<String, List<String>> j = Collections.list(request.getHeaderNames()).stream().         
         collect(Collectors.toMap( jj -> request.getHeaderNames().toString(), 
                 null));
		 
		 j.forEach((K,V)->{
			 System.out.println(K.toString()+" - "+ V);
		 });
		
		 
		
		return null;
	}	
	
}
