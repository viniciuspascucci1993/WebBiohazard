package com.vinicius.web.biohazard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.web.biohazard.domain.WeaponCategory;
import com.vinicius.web.biohazard.repositories.WeaponCategoryRepository;

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
		return weaponCategory.orElse(null);
	}
}
