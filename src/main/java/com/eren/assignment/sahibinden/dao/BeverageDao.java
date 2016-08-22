package com.eren.assignment.sahibinden.dao;

import java.util.List;

import com.eren.assignment.sahibinden.entity.Beverage;

public interface BeverageDao extends BaseDao<Beverage> {
	public List<Beverage> getAllBeverages();

	public Beverage getBeverageWithName(String name);
}
