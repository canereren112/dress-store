package com.eren.dstore.service.model;

public class EntityStats {
	private String name;
	private long totalCost;
	private long reducedCost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public long getReducedCost() {
		return reducedCost;
	}

	public void setReducedCost(long reducedCost) {
		this.reducedCost = reducedCost;
	}

	@Override
	public String toString() {
		return "EntityCost [name=" + name + ", totalCost=" + totalCost + ", reducedCost=" + reducedCost + "]";
	}

}
