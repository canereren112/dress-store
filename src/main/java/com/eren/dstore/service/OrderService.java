package com.eren.dstore.service;

import java.util.List;

import com.eren.dstore.exception.ServiceResponse;
import com.eren.dstore.service.model.EntityStats;
import com.eren.dstore.service.model.ShoppingCart;

public interface OrderService {

	public ServiceResponse checkoutOrder(ShoppingCart cart);
	
	public List<EntityStats> getStatsforUsers();
	
	public List<EntityStats> getStatsforBeverages();
	
	public List<EntityStats> getStatsforCondiments();
}
