package com.vinicius.web.biohazard.domain.enums;

/**
 * Tipo enumerado que representa os tipos das divisões em Resident evil.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
public enum TypeDivision {
	
	STARS(1, "S.T.A.R.S"),
	UBCS(2, "U.B.C.S"),
	UMBRELLA_CORPS(3, "Umbrella Corporation");
	
	/**
	 * Represents the code.
	 */
	private int code;
	
	/**
	 * Represents the description.
	 */
	private String description;
	
	/**
	 * Constructor using fields.
	 * @param code - int - code.
	 * @param description - String - description.
	 */
	private TypeDivision(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * get() method.
	 * @return the code.
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * set() method.
	 * @param code as param.
	 */
	public void setCode(final int code) {
		this.code = code;
	}

	/**
	 * get() method.
	 * @return the description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * set() method.
	 * @param description as param
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	
	/**
	 * Method that receive a code of type of division and return an object of TypeDivision.
	 * @param codigo
	 * @return TypeDivision - Enum.
	 */
	public static TypeDivision toEnum(Integer code) {
		
		if (code == null) {
			return null;
		}
		
		for (TypeDivision typeDivision : TypeDivision.values()) {
			
			if (code.equals(typeDivision.getCode())) {
				
				return typeDivision;
			}
		}
		
		throw new IllegalArgumentException("Invalid Identifier: " + code);
	}
	
}
