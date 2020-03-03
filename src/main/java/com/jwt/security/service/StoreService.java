package com.jwt.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.security.exception.UserException;
import com.jwt.security.model.Item;
import com.jwt.security.model.Stores;
import com.jwt.security.repository.ItemRepo;
import com.jwt.security.repository.StoreRepo;
import com.jwt.security.util.Response;
import com.jwt.security.util.Storeresponse;

@Service
public class StoreService {
	
	private static final Logger log = LoggerFactory.getLogger(StoreService.class);
	
	@Autowired
	private StoreRepo storeRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	public Storeresponse AddStore(Stores store, String requestID){
		Storeresponse response = new Storeresponse();
		try{
			storeRepo.save(store);
			response.setRequestID(requestID);
			response.setReturnCode("200");
			response.setReturnMsg("Store added successfully");
			return response;
		}catch(Exception e){
			response.setRequestID(requestID);
			response.setReturnCode("500");
			response.setReturnMsg("Error occured while adding store details");
			return response;
		}
		
	}
	
	public Storeresponse getStores(String requestID) throws UserException{
		Storeresponse response = new Storeresponse();
		try{
			Iterable<Stores> data = storeRepo.findAll();
			log.info("[{}]", data);
			response.setRequestID(requestID);
			response.setReturnCode("200");
			response.setStores(data);
			return response;
		}catch (Exception e) {
			log.info("[{}]", new UserException("Error occured while getting store details"));
			throw new UserException("Error occured while getting store details");
		}
		
	}
	
	public Storeresponse getStore(String storename, String requestID) throws UserException{
		Storeresponse response = new Storeresponse();
		Stores store = storeRepo.findByStorename(storename);
		log.info("[{}]", store.getClass());
		if(store == null){
			log.info("[{}]", new UserException("Store not found"));
			throw new UserException("Store not found");
		}
		response.setRequestID(requestID);
		response.setReturnCode("200");
		response.setStore(store);
		return response;
	}
	
	public Response AddItem(Item item, String requestID) throws UserException{
		Response response =new Response();
		try{
			itemRepo.save(item);
			response.setRequestID(requestID);
			response.setReturnCode("200");
			response.setReturnMsg("item added");
			return response;
		}catch (Exception e) {
			log.info("[{}]", new UserException("Error occured while adding item details"));
			throw new UserException("Error occured while adding item details");
		}
	}
	
	public Response deleteStore(String storename, String requestID) throws UserException{
		Response response= new Response();
		try{
			//Stores store = storeRepo.findByStorename(storename);
//			long sid = storeRepo.findById(storename);
			storeRepo.deleteByStorename(storename);
//			itemRepo.deleteBySid(sid);
			response.setRequestID(requestID);
			response.setReturnCode("200");
			response.setReturnMsg(String.format("%s store deleted", storename));
			return response;
		}catch(Exception e){
			throw new UserException("Error occured while deleting store");
		}
	}

}
