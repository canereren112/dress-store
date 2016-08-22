package com.eren.assignment.sahibinden.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.assignment.sahibinden.dao.OrderDao;
import com.eren.assignment.sahibinden.entity.Order;
import com.eren.assignment.sahibinden.service.model.EntityStats;

@Repository
public class OrderDaoJpa extends BaseDaoJpa<Order> implements OrderDao {

	public List<EntityStats> getStatsforUsers() {
		return getEntityManager().createQuery(
				"select u.userName, sum(o.totalCost),sum(o.reducedCost) from Order o join o.user u group by u.id")
				.getResultList();
	}

}
