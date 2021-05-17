package com.vinicius.web.biohazard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.web.biohazard.domain.Weapon;
import com.vinicius.web.biohazard.repositories.WeaponRepository;
import com.vinicius.web.biohazard.service.exception.ObjectNotFoundException;

/**
 * Classe de service responsável por conter operações de CRUD só que pela camada de serviço que será alimentada pela camada de resource.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Service
public class WeaponService {
	
	private WeaponRepository weaponRepository;
	
	private WeaponCategoryService weaponCategoryService;

	@Autowired
	public WeaponService(WeaponRepository weaponRepository, WeaponCategoryService weaponCategoryService) {
		this.weaponRepository = weaponRepository;
		this.weaponCategoryService = weaponCategoryService;
	}
	
	public Weapon findById( Integer id ) {
		
		Optional<Weapon> weapon = weaponRepository.findById(id);
		return weapon.orElseThrow(() -> new ObjectNotFoundException("Identifier was not found! Id:" + id + ", Type: " + Weapon.class.getName()));
	}
	
	public List<Weapon> findAlli(Integer id_weap) {
		
		weaponCategoryService.findById(id_weap);
		return weaponRepository.findAllByWeaponCategory(id_weap);
	}

	public Weapon update(Integer id, Weapon obj) {
		
		Weapon newObj = findById(id);
		updateData(newObj, obj);
		
		return weaponRepository.save(newObj);
	}

	private void updateData(Weapon newObj, Weapon obj) {
		
		newObj.setName(obj.getName());
		newObj.setPrice(obj.getPrice());
		newObj.setManufactor(obj.getManufactor());
		newObj.setDateManufacturing(obj.getDateManufacturing());
		
	}
	

}
