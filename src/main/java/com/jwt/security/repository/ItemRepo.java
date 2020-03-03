package com.jwt.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.jwt.security.model.Item;

public interface ItemRepo extends CrudRepository<Item, Long>{

}
