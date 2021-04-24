package com.vinicius.web.biohazard.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.web.biohazard.service.DBService;

/**
 * Perfil de Dev.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Configuration
@Profile("dev")
public class ProfileDevConfig {
	
	private DBService dbService;
	
	// captura o valor do arquivo aplication-dv.properties
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Autowired
	public ProfileDevConfig( DBService service ) {
		this.dbService = service;
	}
	
	/**
	 * method that instaciate dataBase on dev profile.-
	 */
	@Bean
	public boolean instaciateDataBase() throws ParseException { 
		
		if (strategy.equals("create")) {
			dbService.instanciateDataBase();
		}
		
		return false;
		
	}

}
