package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AccessLevel; 
import lombok.Builder; import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_Id;
	private String name;
	private String password;
	private String role;


	
	
	
	@Builder
	public UserEntity (long user_Id,String name,String password,String role){
		this.user_Id = user_Id;
		this.name = name;
		this.password = password;
		this.role = role;

	}
		// TODO Auto-generated method stub
}
	
