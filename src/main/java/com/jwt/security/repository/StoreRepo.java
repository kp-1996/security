package com.jwt.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.jwt.security.model.Stores;

public interface StoreRepo extends CrudRepository<Stores, Long>{
	
	long findById(String storename);
	Stores findByStorename(String storename);
	Iterable<Stores> findAll();
	
	void deleteByStorename(String storename);

}
