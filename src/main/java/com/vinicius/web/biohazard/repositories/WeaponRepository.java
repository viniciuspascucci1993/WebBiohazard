package com.vinicius.web.biohazard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.web.biohazard.domain.Weapon;

/**
 * Repository for Weapon
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer>{ }
