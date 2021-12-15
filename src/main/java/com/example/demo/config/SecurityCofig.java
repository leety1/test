package com.example.demo.config;

import org.antlr.v4.parse.GrammarTreeVisitor.exceptionHandler_return;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityCofig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf()
				.disable()
			.httpBasic()	
				.disable()
			.authorizeRequests()
				.antMatchers("/Login","/signUp","/index","/Chart","/socket","/user","/Chart/bar").permitAll()
				.antMatchers("/").hasRole("USER")
				.antMatchers("/admin").hasRole("ADMIN")
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
