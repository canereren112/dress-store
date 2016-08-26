package com.eren.dstore.dao;

import java.util.List;

import com.eren.dstore.entity.OrderItemDetail;
import com.eren.dstore.service.model.EntityStats;

public interface OrderItemDetailDao extends BaseDao<OrderItemDetail> {
	public List<EntityStats> getStatsforCondiments();
}
