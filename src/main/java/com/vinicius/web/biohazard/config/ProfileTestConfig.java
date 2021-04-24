package com.vinicius.web.biohazard.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.web.biohazard.service.DBService;

/**
 * Perfil de Test.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Configuration
@Profile("test")
public class ProfileTestConfig {

	private DBService dbService;
	
	@Autowired
	public ProfileTestConfig( DBService service ) {
		this.dbService = service;
	}
	
	/**
	 * method that instaciate dataBase on test profile.
	 */
	@Bean
	public boolean instaciateDataBase() throws ParseException { 
		
		dbService.instanciateDataBase();
		
		return true;
		
	}
}
