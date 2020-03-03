package com.jwt.security.repository;


import org.springframework.data.repository.CrudRepository;

import com.jwt.security.model.UserModel;

public interface UserRepo extends CrudRepository<UserModel, Long>{
	UserModel findByUsername(String username);
	Iterable<UserModel> findAll();

}
