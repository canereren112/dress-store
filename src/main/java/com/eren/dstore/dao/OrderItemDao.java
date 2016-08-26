package com.eren.assignment.sahibinden.dao;

import java.util.List;

import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.service.model.EntityStats;

public interface OrderItemDao extends BaseDao<OrderItem> {

	public List<EntityStats> getStatsforBeverages();
}
