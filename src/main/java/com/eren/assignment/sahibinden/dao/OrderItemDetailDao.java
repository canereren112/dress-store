package com.eren.assignment.sahibinden.dao;

import java.util.List;

import com.eren.assignment.sahibinden.entity.OrderItemDetail;
import com.eren.assignment.sahibinden.service.model.EntityStats;

public interface OrderItemDetailDao extends BaseDao<OrderItemDetail> {
	public List<EntityStats> getStatsforCondiments();
}
