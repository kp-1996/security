package com.jwt.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.jwt.security.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{
	Student findByName(String name);
	Iterable<Student> findAll();

}
