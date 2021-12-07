package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class BackedLoginService implements UserDetailService {
	@Autowired
	private UserRepository userReposi;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user= userReposi.findByName(username).orElseThrow(()-> new IllegalArgumentException("존재하지 않은 유저입니다"));
		
		return new User(user.getName(),user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
	}
	



	
}
