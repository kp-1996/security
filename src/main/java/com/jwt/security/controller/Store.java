package com.jwt.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.exception.UserException;
import com.jwt.security.model.Stores;
import com.jwt.security.service.StoreService;
import com.jwt.security.util.Response;
import com.jwt.security.util.Storeresponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Store Management", description = "Managing Stores details")
@RestController
public class Store {
	
	private static final Logger log = LoggerFactory.getLogger(Store.class);
	
	@Autowired
	private StoreService storeService;
	
	@ApiOperation(value = "Add store Details", response = Response.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header"),
		@ApiImplicitParam(name = "requestID", required = true, dataType = "string", paramType = "header")})
	@RequestMapping(value="/addstore", method = RequestMethod.POST)
	public Storeresponse Addstore(
			@ApiParam(name = "request", value = "HttpServlet Request ", required = true) HttpServletRequest request,
			@ApiParam(name = "Payload", value = "Request Body", required = true) @RequestBody Stores stores){
		String methodname = "Add User";
		String requestID = request.getHeader("requestID");
		log.info("[{}]",requestID);
		log.info("[{}] Add user started", methodname);
		Storeresponse response = storeService.AddStore(stores, requestID);
		log.info("[{}]", response.getClass());
		return response;
	}
	
	@ApiOperation(value = "Fetch store Details", response = Iterable.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header"),
		@ApiImplicitParam(name = "requestID", required = true, dataType = "string", paramType = "header")})
	@RequestMapping(value="/getstore", method = RequestMethod.GET)
	public Storeresponse getStores(
			@ApiParam(name = "request", value = "HttpServlet Request ", required = true) HttpServletRequest request)
					throws UserException{
		String requestID = request.getHeader("requestID");
		return storeService.getStores(requestID);
	}
	
	@ApiOperation(value = "Fetch Specified store Details", response = Stores.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header"),
		@ApiImplicitParam(name = "requestID", required = true, dataType = "string", paramType = "header")})
	@RequestMapping(value="/getstore/{storename}", method = RequestMethod.POST)
	public Storeresponse getStore(
			@ApiParam(name = "request", value = "HttpServlet Request ", required = true) HttpServletRequest request,
			@PathVariable String storename)
					throws UserException{
		String requestID = request.getHeader("requestID");
		return storeService.getStore(storename, requestID);
	}
	
	@ApiOperation(value ="Delete Store from DB", response=Storeresponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header"),
		@ApiImplicitParam(name = "requestID", required = true, dataType = "string", paramType = "header")})
	@RequestMapping(value="/deleteStore/{storename}", method=RequestMethod.DELETE)
	public Response deleteStore(@ApiParam(name = "request", value = "HttpServlet Request ", required = true) HttpServletRequest request,
			@PathVariable String storename) throws UserException{
		String requestID = request.getHeader("requestID");
		Response response = storeService.deleteStore(storename, requestID);
		return response;
	}
}
