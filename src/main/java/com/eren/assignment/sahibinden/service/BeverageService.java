package com.eren.assignment.sahibinden.service;

import java.util.List;

import com.eren.assignment.sahibinden.entity.Beverage;
import com.eren.assignment.sahibinden.exception.ServiceResponse;

public interface BeverageService {
	public List<Beverage> getAllBeverages();

	public Beverage getBeverage(long id);

	public Beverage getActiveBeverage(long id);

	public ServiceResponse createNewBeverage(Beverage beverage);

	public ServiceResponse updateBeverage(Beverage beverage);

	public ServiceResponse removeBeverage(long id);

}
