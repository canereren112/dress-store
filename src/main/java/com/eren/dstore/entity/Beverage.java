package com.eren.assignment.sahibinden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.eren.assignment.sahibinden.entity.enums.HISTORICAL_ENTITY_STATUS;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Beverage extends HistoricalEntity {

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
		return "Beverage [name=" + name + ", description=" + ", cost=" + cost + ", getId()=" + getId() + "]";
	}

	@JsonIgnore
	public boolean isActive() {
		return HISTORICAL_ENTITY_STATUS.ACTIVE.getCode().equals(getStatus());
	}

}
