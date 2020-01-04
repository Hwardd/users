package com.user.ms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.user.ms.domain.User;
public interface Userepo extends MongoRepository<User,String> {

	User findByUser(String id);
	Boolean existsByUser(String user);
	
}
