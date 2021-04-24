package com.vinicius.web.biohazard.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe responsável por conter os atributos da arma.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Entity
public class Weapon implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the weapon's identifier.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Represents the name of the weapon.
	 */
	private String name;
	
	/**
	 * Represents the price of the weapon.
	 */
	private Double price;
	
	/**
	 * Represents the manufactor's name.
	 */
	private String manufactor;
	
	/**
	 * Represents the date was created the weapon.
	 */
	private LocalDate dateManufacturing;
	
	/**
	 * Represent one weapon's category.
	 */
	@ManyToOne
	@JoinColumn(name = "weapon_id")
	private WeaponCategory weaponCategory;
	
	/**
	 * The constructor empty;
	 */
	public Weapon() { }

	/**
	 * The constructor using fields.
	 * @param id - Integer - identifier of the weapon.
	 * @param name - String - name of the weapon.
	 * @param price - Double - price of the weapon.
	 * @param manufactor - String - manufactor's name.
	 * @param dateManufacturing - LocalDate - Date was created the weapon.
	 * @param weaponCategory - WeaponCategory - weapon category.
	 */
	public Weapon(Integer id, String name, Double price, String manufactor, LocalDate dateManufacturing,
			WeaponCategory weaponCategory) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufactor = manufactor;
		this.dateManufacturing = dateManufacturing;
		this.weaponCategory = weaponCategory;
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

	/**
	 * get() method.
	 * @return weapon's price.
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * set() method.
	 * @param price - price as param.
	 */
	public void setPrice(final Double price) {
		this.price = price;
	}

	/**
	 * get() method.
	 * @return manufactor's name.
	 */
	public String getManufactor() {
		return this.manufactor;
	}

	/**
	 * set() method.
	 * @param manufactor - manufactor as param.
	 */
	public void setManufactor(final String manufactor) {
		this.manufactor = manufactor;
	}

	/**
	 * get() method.
	 * @return manufactoring date.
	 */
	public LocalDate getDateManufacturing() {
		return this.dateManufacturing;
	}

	/**
	 * set() method.
	 * @param dateManufacturing - manufactoringDate as param.
	 */
	public void setDateManufacturing(final LocalDate dateManufacturing) {
		this.dateManufacturing = dateManufacturing;
	}

	/**
	 * get() method.
	 * @return weaponCategory.
	 */
	public WeaponCategory getWeaponCategory() {
		return this.weaponCategory;
	}

	/**
	 * set() method.
	 * @param weaponCategory - WeaponCategory as param.
	 */
	public void setWeaponCategory(final WeaponCategory weaponCategory) {
		this.weaponCategory = weaponCategory;
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
		Weapon other = (Weapon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
