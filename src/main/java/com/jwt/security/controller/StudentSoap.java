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

import com.client.jwt.security.StudentDetails;
import com.jwt.security.exception.UserException;
import com.jwt.security.service.StudentService;
import com.jwt.security.util.Studentresponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="Student Management")
@RestController
public class StudentSoap {
	
	private static final Logger log = LoggerFactory.getLogger(StudentSoap.class);
	
	@Autowired
	private StudentService studentService;
	
	@ApiOperation(value="Add Student Details", response=Studentresponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header"),
		@ApiImplicitParam(name = "requestID", required = true, dataType = "String", paramType = "header")})
	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	public Studentresponse addStudent(
			@ApiParam(name = "request", value = "HttpServlet Request ", required = true) HttpServletRequest request,
			@ApiParam(name = "Payload", value = "Request Body", required = true) @RequestBody StudentDetails studentDetails)
			throws UserException{
		log.info("[{}] Started [{}]", "AddStudent", studentDetails);
		String requestID = request.getHeader("requestID");
		Studentresponse response = studentService.Addstudent(studentDetails, requestID);
		return response;
	}
	
	@ApiOperation(value="Fetch Student details", response=Studentresponse.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header"),
		@ApiImplicitParam(name= "requestId", required = true, dataType = "string", paramType = "header")
	})
	@RequestMapping(value="/getdetails/{name}", method=RequestMethod.GET)
	public Studentresponse getStudent(
			@ApiParam(name = "request", value = "HttpServlet Request", required = true) HttpServletRequest request,
			@PathVariable String name) throws UserException{
		String requestID = request.getHeader("requestID");
		Studentresponse response = studentService.getStudent(name, requestID);
		return response;
	}
	

}
