package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
	

	@Bean
	static DataSource dataSource() {
		DataSourceBuilder dsb = DataSourceBuilder.create();
		dsb.driverClassName("com.mysql.cj.jdbc.Driver");
		dsb.username("admin");
		dsb.password("test12345");
		dsb.url("jdbc:mysql://database-1.cfpy0mnyxcis.us-east-2.rds.amazonaws.com/sys?useSSL=false&serverTimezone=UTC");
		
		System.out.println("DB 접속 Succes"+dsb);
		return dsb.build();	
	}
	
}
