package com.eren.assignment.sahibinden.entity.enums;

public enum USER_TYPE {
	MEMBER("M"), ADMIN("A");

	/**
	 * Instantiates a new partner group.
	 *
	 * @param code
	 *            the code
	 */
	private USER_TYPE(String code) {
		this.code = code;
	}

	/** The code. */
	String code;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}