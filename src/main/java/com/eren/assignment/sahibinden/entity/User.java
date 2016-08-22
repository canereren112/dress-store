package com.eren.assignment.sahibinden.entity;

import com.eren.assignment.sahibinden.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User extends BaseEntity implements Serializable {

	@Column(length = 50, nullable = false, unique = true)
	private String userName;

	@JsonIgnore
	private String password;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String surname;
	@Column(length = 1, nullable = false)
	private String userType;

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Transient
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", userType=" + userType + ", getId()=" + getId() + "]";
	}

}
