package com.vinicius.web.biohazard.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.web.biohazard.domain.Agent;
import com.vinicius.web.biohazard.domain.Weapon;
import com.vinicius.web.biohazard.domain.WeaponCategory;
import com.vinicius.web.biohazard.domain.enums.TypeDivision;
import com.vinicius.web.biohazard.repositories.AgentRepository;
import com.vinicius.web.biohazard.repositories.WeaponCategoryRepository;
import com.vinicius.web.biohazard.repositories.WeaponRepository;


/**
 * Classe responsável por instanciar a base de dados no perfil de test
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Service
public class DBService {
	
	private WeaponCategoryRepository weaponCategoryRepository;
	
	private WeaponRepository weaponRepository;
	
	private AgentRepository agentRepository;
	
	@Autowired
	public DBService( WeaponCategoryRepository weaponCategoryRepository, WeaponRepository wepRepository, AgentRepository agentRepository) {
		this.weaponCategoryRepository = weaponCategoryRepository;
		this.weaponRepository = wepRepository;
		this.agentRepository = agentRepository;
	}
	
	public void instanciateDataBase() throws ParseException {
		
		WeaponCategory weaponCategory = new WeaponCategory(null, "Beretta M92FS", "Capacidade de munição: 15 balas por vez.\n" + 
				"Arma usada por Jill e também por Chris. A munição não é escassa e, apesar de ser uma arma razoável, é boa para matar zumbis e cães, para não desperdiçar munição de armas mais fortes.");
		
		Weapon weapon = new Weapon(null, "Beretta M92FS", 1700.00, "Barry Burton", LocalDate.of(1972, 11, 6), weaponCategory);
		
		WeaponCategory weaponCategory2 = new WeaponCategory(null, "Espingarda Remington M870 (Shotgun)", "Capacidade de munição: 7 cartuchos por vez.\n" + 
				"Uma boa arma para enfrentar qualquer tipo de inimigos, desde zumbis até chimeras. Costuma ser a preferida de todos os jogadores, que se divertem em mirá-la na cabeça dos zumbis e apertar o gatilho.");
		
		Weapon weapon2 = new Weapon(null, "Espingarda Remington M870 (Shotgun)", 2200.00, "Barry Burton", LocalDate.of(1977, 02, 4), weaponCategory2);
		
		WeaponCategory weaponCategory3 = new WeaponCategory(null, "Colt Python (Magnum)", "Capacidade de munição: 6 balas no tambor.\n" + 
				"É uma das melhores armas do jogo, mata desde zumbis até hunters e o poderoso Tyrant com agilidade e pouquíssimos tiros. É, definitivamente, a melhor arma contra os Hunters, pois basta um tiro para acabar com um deles.");
		
		Weapon weapon3 = new Weapon(null, "Colt Python (Magnum)", 2700.00, "Barry Burton", LocalDate.of(1964, 01, 12), weaponCategory3);
		
		WeaponCategory weaponCategory4 = new WeaponCategory(null, "Bazuca (Bazooka)", "Capacidade de munição: 6 cartuchos.\r\n" + 
				"Tipos de munição: Acid, Explosive e Flame Rounds.\r\n" + 
				"Arma usada somente por Jill, é extremamente poderosa contra qualquer inimigo, e seja qual for a munição que estiver nela equipada. Costuma matar até as chimeras com apenas um tiro");
		
		Weapon weapon4 = new Weapon(null, "Bazuca (Bazooka)", 5500.00, "Mikhail Victor", LocalDate.of(1861, 01, 04), weaponCategory4);
		
		Agent agent = new Agent(null, "Jill Valentime", "jill.valentime@starscorp.com", 1533L, UUID.randomUUID().toString(), TypeDivision.STARS);
		Agent agent2 = new Agent(null, "Carlos Oliveira", "carlos.oliveira@ubcs.com", 2231L, UUID.randomUUID().toString(), TypeDivision.UBCS);
		
		
		weaponCategory.getWeaponCategory().addAll(Arrays.asList(weapon));
		weaponCategory2.getWeaponCategory().addAll(Arrays.asList(weapon2));
		weaponCategory3.getWeaponCategory().addAll(Arrays.asList(weapon3));
		weaponCategory4.getWeaponCategory().addAll(Arrays.asList(weapon4));
		
		agent.getCellphones().addAll(Arrays.asList("(11) 97854-5547", "(11) 99854-2311"));
		agent2.getCellphones().addAll(Arrays.asList("(11) 97854-1144", "(11) 99854-0025"));
		
		this.weaponCategoryRepository.saveAll(Arrays.asList(weaponCategory, weaponCategory2, weaponCategory3, weaponCategory4));
		this.weaponRepository.saveAll(Arrays.asList(weapon, weapon2, weapon3, weapon4));
		
		this.agentRepository.saveAll(Arrays.asList(agent, agent2));
	}

}
