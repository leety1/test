package com.example.demo.dto;
import com.example.demo.login.UserEntity;
import com.example.demo.login.UserEntity.UserEntityBuilder;

import lombok.*;

import java.time.LocalDate;

public class UserDTO {
	private long user_Id;
	private String name;
	private String password;
	private String role;
	private String ADDRESS;
	
	public UserEntity toEntity() {
		return UserEntity.builder()
				.user_Id(user_Id)
				.name(name)
				.password(password)
				.role(role)
				.ADDRESS(ADDRESS)
				.build();
		}
	@Builder
	public UserDTO(long user_Id, String name, String password, String role, String ADDRESS) {
		super();
		this.user_Id = user_Id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.ADDRESS = ADDRESS;
	}
}
