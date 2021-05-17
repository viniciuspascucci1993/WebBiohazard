package com.vinicius.web.biohazard.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

/**
 * Classe responsável por conter os atributos da categoria da arma, 
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Entity
public class WeaponCategory implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the category weapon's identifier.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * Represent a List of weapons.
	 */
	@OneToMany(mappedBy = "weaponCategory")
	private List<Weapon> weapon = new ArrayList<Weapon>();
	
	/**
	 * The constructor empty.
	 */
	public WeaponCategory() {  }

	/**
	 * The constructor using fields;
	 * @param id - Integer - Identifier of the category weapon.
	 * @param name - String - Name of the category weapon.
	 * @param description - String - Description of the ctegory weapon.
	 */
	public WeaponCategory(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	/**
	 * get() method.
	 * @return a List of weapon.
	 */
	public List<Weapon> getWeapon() {
		return this.weapon;
	}

	/**
	 * set() method.
	 * @param weaponsCategory - List of weapon  as param.
	 */
	public void setWeapon(List<Weapon> weapon) {
		this.weapon = weapon;
	}

	/**
	 * Method hasCode() to generate a hashCode from an id.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Method equals() to compare an object only by id.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeaponCategory other = (WeaponCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
