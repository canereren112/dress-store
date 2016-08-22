package com.eren.assignment.sahibinden.dao;

import java.util.List;

import com.eren.assignment.sahibinden.entity.Condiment;

public interface CondimentDao extends BaseDao<Condiment> {
	public List<Condiment> getAllCondiments();

	public Condiment getCondimentWithName(String name);
}
