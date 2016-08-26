package com.eren.assignment.sahibinden.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.assignment.sahibinden.dao.OrderItemDao;
import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.service.model.EntityStats;

@Repository
public class OrderItemDaoJpa extends BaseDaoJpa<OrderItem> implements OrderItemDao {

	public List<EntityStats> getStatsforBeverages() {
		return getEntityManager().createQuery(
				"select b.name, sum(o.totalCost) from OrderItem o join o.beverage b group by b.id")
				.getResultList();
	}
}
