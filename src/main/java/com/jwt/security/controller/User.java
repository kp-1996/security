package com.jwt.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.model.UserModel;
import com.jwt.security.repository.UserRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "JWT User management")
@RestController
public class User {
	
	private static final Logger log = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserRepo userRepo;
		
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
    @ApiOperation(value = "Add user", response = String.class)
	@RequestMapping(value ="/adduser", method=RequestMethod.POST)
	public String addUser(@RequestBody UserModel userdetails) throws Exception{
		final String methodname = "addUser";
		log.info("[{}]: Add User started", methodname);
		userdetails.setPassword(bCryptPasswordEncoder.encode(userdetails.getPassword()));
		try{
			userRepo.save(userdetails);
			log.info("User Added Successfully");
		}
		catch (Exception e){
			return "An error occured while inserting user details";
		}
		log.info("[{}]: Add User Ended", methodname);
		return "User added successfuly";
		
	}
	
	
	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, dataType = "string", paramType = "header")})
	@RequestMapping(value="/getusers", method=RequestMethod.GET)
	public Iterable<UserModel> getusers(
			@ApiParam(name = "request", value = "HttpServlet Request ", required = true) HttpServletRequest request){
		final String methodname = "GetUsers";
		log.info("[{}] Get users started ", methodname);
		Iterable<UserModel> return_user = userRepo.findAll();
		log.info("[{}] Get users Ended ", methodname);
		return return_user;
	}

}
