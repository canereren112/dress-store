package com.eren.assignment.sahibinden.dao;

import java.util.List;

import com.eren.assignment.sahibinden.entity.Order;
import com.eren.assignment.sahibinden.service.model.EntityStats;

public interface OrderDao extends BaseDao<Order> {
	public List<EntityStats> getStatsforUsers();
}
