package com.alemeza.examenfinal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alemeza.examenfinal.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	
	User findByEmail(String email);
}
