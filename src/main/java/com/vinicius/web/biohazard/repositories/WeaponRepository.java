package com.vinicius.web.biohazard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vinicius.web.biohazard.domain.Weapon;

/**
 * Repository for Weapon
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer>{

	@Query("SELECT obj FROM Weapon obj WHERE obj.weaponCategory.id = :id_weap ORDER BY name")
	List<Weapon> findAllByWeaponCategory( @Param(value = "id_weap") Integer id_weap); 
	
}
