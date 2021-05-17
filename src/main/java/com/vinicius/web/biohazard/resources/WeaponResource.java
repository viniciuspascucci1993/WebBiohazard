package com.vinicius.web.biohazard.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.web.biohazard.domain.Weapon;
import com.vinicius.web.biohazard.domain.dto.WeaponDTO;
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
	
	@GetMapping
	public ResponseEntity<List<WeaponDTO>> findAll( @RequestParam(value = "weaponCategory", defaultValue = "0") Integer id_weap) {
		
		List<Weapon> list = weaponService.findAlli(id_weap);
		
		List<WeaponDTO> listDto = list.stream().map(obj -> new WeaponDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Weapon> update( @PathVariable Integer id, @RequestBody Weapon obj ) {
		
		Weapon newObj = weaponService.update(id, obj );
		return ResponseEntity.ok().body(newObj); 
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Weapon> updatePatch( @PathVariable Integer id, @RequestBody Weapon obj ) {
		
		Weapon newObj = weaponService.update(id, obj );
		return ResponseEntity.ok().body(newObj); 
	}
}
