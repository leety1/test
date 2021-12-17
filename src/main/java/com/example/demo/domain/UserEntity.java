package com.example.demo.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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
	@Column(unique = true,nullable  = false)
	private String name;
	@Column(nullable  = false)
	private String password;
	@Column(nullable  = false)
	private String role;


	@Builder
	public UserEntity (long user_Id,String name,String password,String role){
		this.user_Id = user_Id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public Collection<? extends GrantedAuthority> getAuthorities(){
		Set<GrantedAuthority> roles = new HashSet<>();
		
		for(String role:role.split(",")) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return roles;
	}
	
	public boolean isAcntNonExpired() {
		return true;//만료되지 않음
	}
	public boolean isAcntNonLocked() {
		return true;//잠기지 않음
	}
	public boolean isCredentialNonExpired() {
		return true;//잠기지 않음
	}
	public boolean isEnabled() {
		return true;//잠기지 않음
	}
}
	
