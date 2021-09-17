package com.codename.unity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Member {
	
	private @Id @GeneratedValue long id;
	private String name;
	private String surname;
	private String role;
	
	public Member(String name, String surname, String role) {
		super();
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
	
	public Member() {
		
	}
	
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + surname + "(" + role + ")";
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}






	
}
