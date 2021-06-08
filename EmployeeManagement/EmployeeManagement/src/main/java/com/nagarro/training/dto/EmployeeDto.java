package com.nagarro.training.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class EmployeeDto {
	
	private long id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "Location is mandatory")
	private String location;
	@NotBlank(message = "Email is mandatory")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Email not valid")
	private String email;
	@NotBlank(message = "Date of birth is mandatory")
	private String dob;

	public EmployeeDto() {

	}

	public EmployeeDto(String name, String location, String email, String dob) {
		super();
		this.name = name;
		this.location = location;
		this.email = email;
		this.dob = dob;
	}

	public EmployeeDto(long id, String name, String location, String email, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
		this.dob = dob;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
