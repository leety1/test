package com.example.demo.login;

import javax.persistence.Entity; import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType; import javax.persistence.Table;

import javax.persistence.Id;

import lombok.AccessLevel; 
import lombok.Builder; import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_Id;
	private String name;
	private String password;
	private String role;
	private String ADDRESS;
	
	
	@Builder
	public UserEntity (long user_Id,String name,String password,String role,String ADDRESS){
		this.user_Id = user_Id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.ADDRESS = ADDRESS;
		
	}
		// TODO Auto-generated method stub
}
	
