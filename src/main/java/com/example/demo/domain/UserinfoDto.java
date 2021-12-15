package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserinfoDto {
	
	private String name;
	private String password;
	private String role;
	@Builder
	public UserinfoDto (String name,String password,String role) {
		// TODO Auto-generated method stub
		this.name =name;
		this.password = password;
		this.role = role;
	}
	
	
}
