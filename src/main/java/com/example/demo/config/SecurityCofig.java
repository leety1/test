package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.login.MyLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityCofig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers("/Login","/signUp","/index","/Chart")
					.permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/Login")
				.loginProcessingUrl("/doLogin")
				.usernameParameter("id")
				.passwordParameter("pw")
				.successHandler(new MyLoginSuccessHandler())
				.and()
			.logout()
				.logoutUrl("/doLogout")
				.logoutSuccessUrl("/login");
				
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("머지 이건");
		return encoder;
		
	}


}
