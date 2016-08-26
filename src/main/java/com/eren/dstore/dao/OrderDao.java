package com.eren.dstore.dao;

import java.util.List;

import com.eren.dstore.entity.Order;
import com.eren.dstore.service.model.EntityStats;

public interface OrderDao extends BaseDao<Order> {
	public List<EntityStats> getStatsforUsers();
}
