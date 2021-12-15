package com.example.demo.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.domain.UserEntity;

public interface UserDetailService {

	UserEntity loadUserByUsername(String username) throws UsernameNotFoundException;

}
