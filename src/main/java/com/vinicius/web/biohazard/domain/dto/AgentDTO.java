package com.vinicius.web.biohazard.domain.dto;

import java.io.Serializable;

import com.vinicius.web.biohazard.domain.Agent;

/**
 * Classe DTO para filtrar apenas os dados que precisamos.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public class AgentDTO implements Serializable {

	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents de id.
	 */
	private Integer id;
	
	/**
	 * Represents the name of the category.
	 */
	private String name;
	/**
	 * Represents de code of the squad.
	 */
	private Long code;
	
	/**
	 * Constructor empty
	 */
	public AgentDTO() { }
	
	/**
	 * Construtor passando um Object Agent.
	 * @param objDto
	 */
	public AgentDTO( Agent obj ) {
		id = obj.getId();
		name = obj.getName();
		code = obj.getCode();
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
	public void setName(final String name) {
		this.name = name;
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

}
