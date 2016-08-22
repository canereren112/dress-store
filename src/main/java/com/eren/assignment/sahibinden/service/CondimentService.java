package com.eren.assignment.sahibinden.service;

import java.util.List;

import com.eren.assignment.sahibinden.entity.Condiment;
import com.eren.assignment.sahibinden.exception.ServiceResponse;

public interface CondimentService {
	public List<Condiment> getAllCondiments();

	public Condiment getCondiment(long id);

	public Condiment getActiveCondiment(long id);

	public ServiceResponse createNewCondiment(Condiment Condiment);

	public ServiceResponse updateCondiment(Condiment Condiment);

	public ServiceResponse removeCondiment(long id);

}
