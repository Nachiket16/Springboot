package com.app.pojos;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="users_tbl")
public class User extends BaseEntity{
	@Column(length = 20,name="first_name")
	private String firstName;
	@Column(length = 20,name="last_name")
	private String lastName;
	@Column(length = 20,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	@Column(nullable = false)
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, RoleEnum role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = role;
	}

	//setters n getters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob=" + dob
				+ ", role=" + role + "]";
	}
	
	

}
