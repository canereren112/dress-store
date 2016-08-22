package com.eren.assignment.sahibinden.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.assignment.sahibinden.dao.OrderItemDetailDao;
import com.eren.assignment.sahibinden.entity.OrderItemDetail;
import com.eren.assignment.sahibinden.service.model.EntityStats;

@Repository
public class OrderItemDetailDaoJpa extends BaseDaoJpa<OrderItemDetail> implements OrderItemDetailDao {

	public List<EntityStats> getStatsforCondiments() {
		return getEntityManager().createQuery(
				"select c.name, sum(c.cost * o.count) from OrderItemDetail o join o.condiment c group by c.id")
				.getResultList();
	}
}
