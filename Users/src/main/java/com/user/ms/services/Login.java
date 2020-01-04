package com.user.ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.ms.domain.User;
import com.user.ms.repo.Userepo;

@Service
public class Login {

	@Autowired
	Userepo urepo;

	@Autowired
	Sessioncheck nsession;

	public Boolean verification(String user, String pass) {

		if (urepo.existsByUser(user)) {

			User usr = urepo.findByUser(user);

			if (usr.getPass().equals(pass)) {

				return true;
				
			} else {

				return false;
			
			}
		} else {
			
			return false;
		
		}

	}

	public Boolean fulllogin(String user) {
		
		if (nsession.existus(user)) {
		
			return false;
			
		} else {
			
			nsession.created(user);
			return true;
		
		}
	}

}
