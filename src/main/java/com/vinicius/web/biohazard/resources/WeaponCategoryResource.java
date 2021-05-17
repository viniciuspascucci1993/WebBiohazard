package com.vinicius.web.biohazard.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vinicius.web.biohazard.domain.WeaponCategory;
import com.vinicius.web.biohazard.domain.dto.WeaponCategoryDTO;
import com.vinicius.web.biohazard.service.WeaponCategoryService;

/**
 * Classe de resource responsável por realizar operações de CRUD.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/weapon-category")
public class WeaponCategoryResource {
	
	private WeaponCategoryService weaponCategoryService;
	
	@Autowired
	public WeaponCategoryResource( WeaponCategoryService weaponCategoryService ) {
		this.weaponCategoryService = weaponCategoryService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WeaponCategory> findById( @PathVariable Integer id ) {
		
		WeaponCategory weaponCategory = weaponCategoryService.findById(id);
		return ResponseEntity.ok().body(weaponCategory);
		
	}
	
	@GetMapping
	public ResponseEntity<List<WeaponCategoryDTO>> findAll() {
		
		List<WeaponCategory> list = weaponCategoryService.findAll();
		
		List<WeaponCategoryDTO> listDto = list.stream().map(weaponObj -> new WeaponCategoryDTO(weaponObj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<WeaponCategory> create( @Valid @RequestBody WeaponCategory weaponCategory ) {
		
		weaponCategory = weaponCategoryService.create(weaponCategory);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(weaponCategory.getId()).toUri();
		
		return ResponseEntity.created(uri).body(weaponCategory);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<WeaponCategoryDTO> update( @Valid @PathVariable Integer id, @RequestBody WeaponCategoryDTO objDto ) {
		
		WeaponCategory newObj = weaponCategoryService.update(id, objDto);
		
		return ResponseEntity.ok().body(new WeaponCategoryDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable Integer id ) {
		
		weaponCategoryService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

	
}
