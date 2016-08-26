package com.eren.dstore.dao;

import java.util.List;

import com.eren.dstore.entity.Condiment;

public interface CondimentDao extends BaseDao<Condiment> {
	public List<Condiment> getAllCondiments();

	public Condiment getCondimentWithName(String name);
}
