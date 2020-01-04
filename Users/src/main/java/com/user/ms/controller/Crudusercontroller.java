package com.user.ms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.ms.domain.Session;
import com.user.ms.domain.User;
import com.user.ms.repo.Sessionrepo;
import com.user.ms.repo.Userepo;
import com.user.ms.services.Login;
import com.user.ms.services.Sessioncheck;

@RestController
public class Crudusercontroller {

	@Autowired
	Userepo repou;
    
	@Autowired
	Sessionrepo sck;
	
	@Autowired
	Login lg;
	
	@Autowired
	Sessioncheck sc;

	@GetMapping("/all/{user}/{token}")
	ResponseEntity<?> all(@PathVariable String user, @PathVariable String token) {
		
		if(sc.check(user, token)) {
			
		return ResponseEntity.ok(repou.findAll());
		
		} else {
		
		return ResponseEntity.ok("Acceso denegado!!!");	
		
		}
	}

	@PostMapping("/register")
	ResponseEntity<String> register(@RequestBody User user) {
		repou.save(user);
		return ResponseEntity.ok("Registro exitoso");
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> delete(@PathVariable String id) {
		repou.deleteById(id);
		return ResponseEntity.ok("Registro borrado");

	}

	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody Map<String, String> map) {
		if (lg.verification(map.get("user"), map.get("pass"))) {
			if (lg.fulllogin(map.get("user"))) {
				
				Session ss=sck.findByUser(map.get("user"));
				Map<String,String> maps=new HashMap<String, String>();
				maps.put("user", ss.getUser());
				maps.put("token", ss.getToken());
				
				return ResponseEntity.ok(maps);
			
			} else {
				
				return ResponseEntity.ok("Ya tienes inciada una sesion");
			
			}
		} else {
			
			return ResponseEntity.ok("Datos incorrectos");
	
		}
	}
	
	@PostMapping("/logut")
	ResponseEntity<String> logout(@RequestBody Map<String, String> map) {
		
		if(sc.check(map.get("user"), map.get("token")))
		{
			Session ss=sck.findByUser(map.get("user"));
			sck.delete(ss);
			return ResponseEntity.ok("Sesion finalizada");
			
		}else {
			return ResponseEntity.ok("Rechazado");
		}
		
	}

}
