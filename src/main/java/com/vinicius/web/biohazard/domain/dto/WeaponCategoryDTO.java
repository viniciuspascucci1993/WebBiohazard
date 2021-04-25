package com.vinicius.web.biohazard.domain.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.vinicius.web.biohazard.domain.WeaponCategory;

/**
 * Classe DTO para filtrar apenas os dados que precisamos.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class WeaponCategoryDTO implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the category weapon's identifier.
	 */
	private Integer id;
	
	/**
	 * Represents the name of the category.
	 */
	private String name;
	
	/**
	 * Represents the description of the weapon.
	 */
	@Length( max = 500)
	private String description;
	
	/**
	 * The constructor empty.
	 */
	public WeaponCategoryDTO() { }

	/**
	 * Construtor passando um Object WeaponCategory.
	 * @param objDto
	 */
	public WeaponCategoryDTO(WeaponCategory objDto) {
		id = objDto.getId();
		name = objDto.getName();
		description = objDto.getDescription();
	}

	/**
	 * get() method.
	 * @return the identifier of the category weapon.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * set() method.
	 * @param id - Identifier as param.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * get() method.
	 * @return the name of the category weapon.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set() method.
	 * @param name - Name as param.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * get() method.
	 * @return the description of the category weapon.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * set() method.
	 * @param description - Description as param.
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	
	
}
