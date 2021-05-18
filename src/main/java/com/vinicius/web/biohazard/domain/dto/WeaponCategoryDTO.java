package com.vinicius.web.biohazard.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

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
	@NotEmpty(message = "Field Name is required")
	@Length(min = 3, max = 200, message = "The Field name should have between 3 and 200 characters")
	private String name;
	
	/**
	 * Represents the description of the weapon.
	 */
	@NotEmpty(message = "Field Description is required")
	@Length(min = 1, max = 500, message = "The Field description should have between 1 and 500 characters")
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
