package com.javadream.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(value = {"name","emailId"})
//@JsonIgnoreProperties(value = { "studentName", "studentEmailId" })
@JsonPropertyOrder(value = {"studentId", "studentEmailId" , "studentName"})
public class Student {

	// @JsonIgnore
	@JsonProperty("studentId")
	private long id;

	// @JsonIgnore
	@JsonProperty("studentName")
	private String name;

	// @JsonIgnore
	@JsonProperty("studentEmailId")
	private String emailId;

	public Student(long id, String name, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
