package com.eren.dstore.dao;

import java.util.List;

import com.eren.dstore.entity.Beverage;

public interface BeverageDao extends BaseDao<Beverage> {
	public List<Beverage> getAllBeverages();

	public Beverage getBeverageWithName(String name);
}
