package com.user.ms.repo;

import org.springframework.data.repository.CrudRepository;

import com.user.ms.domain.Session;

public interface Sessionrepo extends CrudRepository<Session,String> {

	Session findByUser(String user);
	void deleteByUser(String user);

}
