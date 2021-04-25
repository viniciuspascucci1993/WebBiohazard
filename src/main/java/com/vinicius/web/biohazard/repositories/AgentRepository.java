package com.vinicius.web.biohazard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.web.biohazard.domain.Agent;

/**
 * Repository for WeaponCategory
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer>{ }
