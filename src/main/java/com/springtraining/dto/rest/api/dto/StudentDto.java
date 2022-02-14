package com.springtraining.dto.rest.api.dto;

import lombok.Data;

@Data
public class StudentDto {

	private Long id;
	private String name;
	private String username;
	private String password;
	private AddressDto address;
}
