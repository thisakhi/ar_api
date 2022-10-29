package com.sakthiit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {

	private String fullname;
	private String email;
	private String phno;
	private Long ssn;
	private LocalDate dob;
	private String gender;
	private String statename;

}
