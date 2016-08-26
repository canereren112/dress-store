package com.eren.dstore.dao;

import java.util.List;

import com.eren.dstore.entity.OrderItem;
import com.eren.dstore.service.model.EntityStats;

public interface OrderItemDao extends BaseDao<OrderItem> {

	public List<EntityStats> getStatsforBeverages();
}
