package com.user.ms.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {

	@Id
	String idm;

	@NotNull
	@NotBlank
	private String user;

	@NotNull
	@NotBlank
	private String pass;

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@NotBlank
	private String lastname;

	@NotNull
	@NotBlank
	private String position;

	@NotNull
	@NotBlank
	private String level;

	public String getId() {
		return idm;
	}

	public void setId(String id) {
		this.idm = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
