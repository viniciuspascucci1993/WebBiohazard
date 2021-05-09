package com.vinicius.web.biohazard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vinicius.web.biohazard.domain.WeaponCategory;
import com.vinicius.web.biohazard.domain.dto.WeaponCategoryDTO;
import com.vinicius.web.biohazard.repositories.WeaponCategoryRepository;
import com.vinicius.web.biohazard.service.exception.ObjectNotFoundException;

/**
 * Classe de service responsável por conter operações de CRUD só que pela camada de serviço que será alimentada pela camada de resource.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Service
public class WeaponCategoryService {

	private WeaponCategoryRepository weaponCategoryRepository;
	
	@Autowired
	public WeaponCategoryService( WeaponCategoryRepository weaponCategoryRepository ) {
		this.weaponCategoryRepository = weaponCategoryRepository;
	}
	
	public WeaponCategory findById( Integer id ) {
		
		Optional<WeaponCategory> weaponCategory = weaponCategoryRepository.findById(id);
		return weaponCategory.orElseThrow(() -> new ObjectNotFoundException("Identifier was not found! Id:" + id + ", Type: " + WeaponCategory.class.getName()));
	}
	
	public List<WeaponCategory> findAll() {
		
		return weaponCategoryRepository.findAll();
	}
	
	public WeaponCategory create( WeaponCategory obj ) {
		
		obj.setId(null);
		return weaponCategoryRepository.save(obj);
	}

	public WeaponCategory update(Integer id, WeaponCategoryDTO objDto) {
		
		WeaponCategory obj = findById(id);
		
		obj.setName(objDto.getName());
		obj.setDescription(objDto.getDescription());
		
		return weaponCategoryRepository.save(obj);
	}

	public void delete(Integer id) {
		
		findById(id);
		
		try {
			weaponCategoryRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new 
				com.vinicius.web.biohazard.service.exception.DataIntegrityViolationException("The Weapon-Category cannot be deleted because has associate Weapons");
		}
	}
}
