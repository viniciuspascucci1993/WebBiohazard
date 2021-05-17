package com.vinicius.web.biohazard.domain.dto;

import java.io.Serializable;

import com.vinicius.web.biohazard.domain.Weapon;

/**
 * Classe DTO para filtrar apenas os dados que precisamos.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class WeaponDTO implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the weapon's identifier.
	 */
	private Integer id;
	
	/**
	 * Represents the name of the weapon.
	 */
	private String name;
	
	/**
	 * Empty Constructor
	 */
	public WeaponDTO() { }
	
	public WeaponDTO( Weapon obj ) {
		id = obj.getId();
		name = obj.getName();
	}
	
	/**
	 * get() method.
	 * @return identifier of the weapon.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * set() method.
	 * @param id - identifier as param.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * get() method.
	 * @return weapons's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set() method.
	 * @param name - name as param.
	 */
	public void setName(final String name) {
		this.name = name;
	}
}
