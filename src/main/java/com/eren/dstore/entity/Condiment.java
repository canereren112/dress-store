package com.eren.dstore.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.eren.dstore.entity.Beverage;
import com.eren.dstore.entity.enums.HISTORICAL_ENTITY_STATUS;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Condiment
 *
 */
@Entity
public class Condiment extends HistoricalEntity implements Serializable {

	@Column(length = 50, nullable = false)
	private String name;

	@Column
	private int cost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Condiment [name=" + name + ", description=" + ", cost=" + cost + ", getId()=" + getId() + "]";
	}

	@JsonIgnore
	public boolean isActive() {
		return HISTORICAL_ENTITY_STATUS.ACTIVE.getCode().equals(getStatus());
	}

}
