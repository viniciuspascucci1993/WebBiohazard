package com.vinicius.web.biohazard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.web.biohazard.domain.WeaponCategory;

/**
 * Repository for WeaponCategory
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface WeaponCategoryRepository extends JpaRepository<WeaponCategory, Integer>{ }
