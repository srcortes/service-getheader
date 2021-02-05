package com.globant.app.header.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.globant.app.header.exceptions.InternalServerErrorException;
import com.globant.app.header.exceptions.NotFoundException;
import com.globant.app.header.response.ManagerApiResponse;
import com.globant.app.header.service.HttpHeaderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(produces = "application/json")
@Validated
@CrossOrigin(origins = "*")
public class HttpHeaderController {
	@Autowired
	HttpHeaderService httpHeaderService;
	@ApiOperation(notes = "Service is responsable for generate list header request", value = "N/A")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Map.class),
	@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerErrorException.class) })
	@GetMapping(value = "/getListHeader")
	public ManagerApiResponse<Map<String, List<String>>> getHeaders() throws InternalServerErrorException{	
		return new ManagerApiResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", httpHeaderService.listHeader());
	}
	@ApiOperation(notes = "Service is responsable for generate list header request", value = "List<String> headerName")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Map.class),
	@ApiResponse(code = 500, message = "Internal Server Error", response = Exception.class),
	@ApiResponse(code = 404, message = "Internal Server Error", response = NotFoundException.class) })	
	@GetMapping(value = "/getHeaderByName/{headerNames}")
	public ManagerApiResponse<Map<String, List<String>>> getHeadersByName(@PathVariable List<String>  headerNames) throws Exception{		
		return new ManagerApiResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", httpHeaderService.listHeaderByName(headerNames));
	}
}
