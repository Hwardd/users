package com.user.ms.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.ms.domain.Session;
import com.user.ms.repo.Sessionrepo;

@Service
public class Sessioncheck {

	@Autowired
	Sessionrepo srepo;

	public Boolean check(String user, String token) {
		Session ss = srepo.findByUser(user);
	
		if (ss != null) {
			
			if (ss.getToken().equals(token)) {
				return true;
			} else {
				return false;
			}

		} else {

			return false;
		}

	}

	public Boolean existus(String user) {
		
		Session ss = srepo.findByUser(user);
		if (ss == null) {
			return false;

		} else {
			return true;
		}
		
	}

	public void created(String user) {

		String token = UUID.randomUUID().toString();
		Session sess = new Session();
		sess.setUser(user);
		sess.setToken(token);
		System.out.println(sess.getUser());
		System.out.println(sess.getToken());
		srepo.save(sess);

	}

}
