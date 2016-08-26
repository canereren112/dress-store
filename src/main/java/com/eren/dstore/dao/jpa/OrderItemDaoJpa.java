package com.eren.dstore.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.dstore.dao.OrderItemDao;
import com.eren.dstore.entity.OrderItem;
import com.eren.dstore.service.model.EntityStats;

@Repository
public class OrderItemDaoJpa extends BaseDaoJpa<OrderItem> implements OrderItemDao {

	public List<EntityStats> getStatsforBeverages() {
		return getEntityManager().createQuery(
				"select b.name, sum(o.totalCost) from OrderItem o join o.beverage b group by b.id")
				.getResultList();
	}
}
