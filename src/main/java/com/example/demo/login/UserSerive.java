package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserEntity;
import com.example.demo.domain.UserRepository;
import com.example.demo.domain.UserinfoDto;

import java.util.Arrays;


@Service
public class UserSerive implements UserDetailService {
	@Autowired
	private UserRepository userReposi;

	public UserEntity loadUserByUsername(String name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user= userReposi.findByName(name).orElseThrow(()-> new UsernameNotFoundException(name));
		
		return user;
//		return new User(user.getName(),user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
	}
	public Long save(UserinfoDto userDto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userDto.setPassword(encoder.encode(userDto.getPassword()));
		
		return userReposi.save(userDto.builder()
				.name(userDto.getName())
				.role(userDto.getRole())
				.password(userDto.getPassword()).build()).getUser_Id();
		
	}
	
	



	
}
