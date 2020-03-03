package com.jwt.security.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jwt.security.model.Stores;

import io.swagger.annotations.ApiModel;

@ApiModel(value="Storepayloadoutput", description="Store Payloadoutput")
@JsonPropertyOrder({"requestID","returnCode","returnMsg"})
public class Storeresponse {
	
	private String requestID;
	private String returnCode;
	private String returnMsg;
	
	private Iterable<Stores> stores;
	private Stores store;
	
	public Stores getStore() {
		return store;
	}

	public void setStore(Stores store) {
		this.store = store;
	}

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

	public Iterable<Stores> getStores() {
		return stores;
	}

	public void setStores(Iterable<Stores> stores) {
		this.stores = stores;
	}

	

}
