package com.jwt.security.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jwt.security.model.Student;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Studentpayloadoutput", description="Student Payloadoutput")
@JsonPropertyOrder({"requestID","returnCode","returnMsg"})
public class Studentresponse {
	
	private String requestID;
	private String returnCode;
	private String returnMsg;
	
	private Student student;

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
