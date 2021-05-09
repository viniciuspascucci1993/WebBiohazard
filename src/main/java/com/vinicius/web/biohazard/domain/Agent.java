package com.vinicius.web.biohazard.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vinicius.web.biohazard.domain.enums.TypeDivision;

/**
 * Classe responsável por identificar os atributos de um agente.
 * @author Vinicius-PC - Vinicius Torres Pascucci,
 */
@Entity
public class Agent implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Represents de id.
	 */
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Represents the name of the category.
	 */
	private String name;
	
	/**
	 * Represents de email.
	 */
	private String email;
	
	/**
	 * Represents de code of the squad.
	 */
	private Long code;
	
	/**
	 * Represents a random number of the team.
	 */
	private String numberCode;
	
	/**
	 * Represents the type of the division.
	 */
	private Integer typeDivision;
	
	@ElementCollection
	@CollectionTable( name = "CELLPHONE")
	private Set<String> cellphones = new HashSet<String>();
	
	/**
	 * Constructor empty
	 */
	public Agent() { }

	/**
	 * Constructor using fields.
	 * @param id - Integer - identifier.
	 * @param email - String - email.
	 * @param code - Long - code.
	 * @param numberCode - String - memberCode.
	 * @param typeDivision - TypeDivision - typeDivision
	 */
	public Agent(Integer id, String name, String email, Long code, String numberCode, TypeDivision typeDivision) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.code = code;
		this.numberCode = numberCode;
		this.typeDivision = ( typeDivision == null ) ? null : typeDivision.getCode(); // função ternária
	}

	/**
	 * get() method.
	 * @return id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * set() method.
	 * @param id as param
	 */
	public void setId(final Integer id) {
		this.id = id;
	}
	

	/**
	 * get() method.
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set() method.
	 * @param name as param.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get() method.
	 * @return email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * set() method.
	 * @param email as param
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * get() method.
	 * @return code.
	 */
	public Long getCode() {
		return this.code;
	}

	/**
	 * set() method.
	 * @param code as param
	 */
	public void setCode(final Long code) {
		this.code = code;
	}

	/**
	 * get() method.
	 * @return memberCode.
	 */
	public String getNumberCode() {
		return this.numberCode;
	}

	/**
	 * set() method.
	 * @param numberCode as param.
	 */
	public void setNumberCode(final String numberCode) {
		this.numberCode = numberCode;
	}

	/**
	 * get() method.
	 * @return typeDivision.
	 */
	public Integer getTypeDivision() {
		return this.typeDivision;
	}

	/**
	 * set() method.
	 * @param typeDivision as param
	 */
	public void setTypeDivision(final Integer typeDivision) {
		this.typeDivision = typeDivision;
	}

	/**
	 * get() method.
	 * @return cellphones.
	 */
	public Set<String> getCellphones() {
		return this.cellphones;
	}

	/**
	 * set() method.
	 * @param cellphones as param
	 */
	public void setCellphones(final Set<String> cellphones) {
		this.cellphones = cellphones;
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
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
