package com.jwt.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.jwt.security.StudentDetails;
import com.jwt.security.exception.UserException;
import com.jwt.security.model.Student;
import com.jwt.security.repository.StudentRepo;
import com.jwt.security.util.Studentresponse;

@Service
public class StudentService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Studentresponse Addstudent(StudentDetails studentDetails, String requestID) throws UserException{
		Student data = new Student();
		Studentresponse studentresponse = new Studentresponse();
		data.setName(studentDetails.getName());
		data.setAge(studentDetails.getAge());
		data.setCourse(studentDetails.getCourse());
		data.setDepartment(studentDetails.getDepartment());
		try{
			studentRepo.save(data);
			studentresponse.setRequestID(requestID);
			studentresponse.setReturnCode("200");
			studentresponse.setReturnMsg("Student details added successfully");
			log.info("[{}] Student details added successfully", studentDetails);
			return studentresponse;
		}catch(Exception e){
			throw new UserException("Error occured while inserting data");
		}
	}
	
	public Studentresponse getStudent(String studen_name, String requestID) throws UserException{
		
		Studentresponse response = new Studentresponse();
		Student data = null;
		try{
			data = studentRepo.findByName(studen_name);
			response.setRequestID(requestID);
			response.setReturnCode("200");
			response.setReturnMsg(studen_name);
			response.setStudent(data);
		}catch(Exception e){
			throw new UserException("Error occured while getting student details");
		}
		if(data==null){
			response.setRequestID(requestID);
			response.setReturnCode("404");
			response.setReturnMsg(String.format("%s Student not found", studen_name));
			return response;
		}
		return response;
		
	}

}
