package com.eren.assignment.sahibinden.entity.enums;

public enum HISTORICAL_ENTITY_STATUS {
    ACTIVE("A"), DEACTIVE("D");

    /**
     * Instantiates a new partner group.
     *
     * @param code
     *          the code
     */
    private HISTORICAL_ENTITY_STATUS(String code) {
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