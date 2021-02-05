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
import com.globant.app.header.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
@Service
@Primary
@Slf4j
public class HttpHeaderServiceImplement implements HttpHeaderService {
	@Autowired
	HttpServletRequest request;	
	Map<String, List<String>> map = new HashMap<>();	
	@Override
	public Map<String, List<String>> listHeader() throws InternalServerErrorException{
		try {		
		 Collections.list(request.getHeaderNames()).stream().forEach(i->{			
			 String [] arreglo = request.getHeaders(i).nextElement().split(",");
			 List<String> lista = Arrays.asList(arreglo);
			 map.put(i,lista);
		 }); 
		
		return map;
		}catch (Exception ex) {
			log.error("Internal Server Error ->" + ex);
			throw new InternalServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error getting header", ex);
		}		
	}
	@Override
	public Map<String, List<String>> listHeaderByName(List<String> headerName) throws Exception {
		Map<String, List<String>> newMap = new HashMap<>();	
	    try {
	    	headerName.forEach(j->{				
				Collections.list(request.getHeaderNames()).stream().filter(i->i.equalsIgnoreCase(j)).forEach(i->{
					String [] lista = request.getHeaders(j.toString().trim()).nextElement().split(",");
					newMap.put(i, Arrays.asList(lista));
				});
			});
	    	if(newMap.isEmpty()) 
	    		 throw new NotFoundException(HttpStatus.NOT_FOUND, null);	    	
	    	
	    	return newMap;		
	    }catch (NotFoundException ex) {
			log.error("No values found: " + headerName);
			throw new NotFoundException(HttpStatus.NOT_FOUND, "No values found");
		}catch (Exception ex) {
			log.error("Internal Server Error ->" + ex);
			throw new InternalServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error getting header", ex);
		}	
		
	}	
}
