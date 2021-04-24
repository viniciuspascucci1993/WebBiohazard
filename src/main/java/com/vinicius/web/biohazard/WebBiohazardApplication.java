package com.vinicius.web.biohazard;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vinicius.web.biohazard.domain.Weapon;
import com.vinicius.web.biohazard.domain.WeaponCategory;
import com.vinicius.web.biohazard.repositories.WeaponCategoryRepository;
import com.vinicius.web.biohazard.repositories.WeaponRepository;

@SpringBootApplication
public class WebBiohazardApplication implements CommandLineRunner {
	
	@Autowired
	private WeaponCategoryRepository weaponCategoryRepository;
	
	@Autowired
	private WeaponRepository weaponRepository;


	public static void main(String[] args) {
		SpringApplication.run(WebBiohazardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		WeaponCategory weaponCategory = new WeaponCategory(null, "Beretta M92FS", "Capacidade de munição: 15 balas por vez.\n" + 
				"Arma usada por Jill e também por Chris. A munição não é escassa e, apesar de ser uma arma razoável, é boa para matar zumbis e cães, para não desperdiçar munição de armas mais fortes.");
		
		Weapon weapon = new Weapon(null, "Beretta M92FS", 1700.00, "Barry Burton", LocalDate.of(1972, 11, 6), weaponCategory);
		
		weaponCategory.getWeaponCategory().addAll(Arrays.asList(weapon));
		
		this.weaponCategoryRepository.saveAll(Arrays.asList(weaponCategory));
		this.weaponRepository.saveAll(Arrays.asList(weapon));
		
	}

}
