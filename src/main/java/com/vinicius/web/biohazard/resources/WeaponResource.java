package com.vinicius.web.biohazard.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.web.biohazard.domain.Weapon;
import com.vinicius.web.biohazard.service.WeaponService;

/**
 * Classe de resource responsável por realizar operações de CRUD.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/weapons")
public class WeaponResource {
	
	private WeaponService weaponService;
	
	@Autowired
	public WeaponResource(WeaponService weaponService) {
		this.weaponService = weaponService;
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<Weapon> findById( @PathVariable Integer id ) {
		
		Weapon weapon = weaponService.findById(id);
		return ResponseEntity.ok().body(weapon);
	}
}
