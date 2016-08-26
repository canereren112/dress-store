package com.eren.dstore.service;

import java.util.List;

import com.eren.dstore.entity.Beverage;
import com.eren.dstore.exception.ServiceResponse;

public interface BeverageService {
	public List<Beverage> getAllBeverages();

	public Beverage getBeverage(long id);

	public Beverage getActiveBeverage(long id);

	public ServiceResponse createNewBeverage(Beverage beverage);

	public ServiceResponse updateBeverage(Beverage beverage);

	public ServiceResponse removeBeverage(long id);

}
