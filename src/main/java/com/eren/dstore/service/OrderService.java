package com.eren.assignment.sahibinden.service;

import java.util.List;

import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.service.model.EntityStats;
import com.eren.assignment.sahibinden.service.model.ShoppingCart;

public interface OrderService {

	public ServiceResponse checkoutOrder(ShoppingCart cart);
	
	public List<EntityStats> getStatsforUsers();
	
	public List<EntityStats> getStatsforBeverages();
	
	public List<EntityStats> getStatsforCondiments();
}
