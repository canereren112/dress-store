package com.eren.assignment.sahibinden.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eren.assignment.sahibinden.dao.BeverageDao;
import com.eren.assignment.sahibinden.entity.Beverage;
import com.eren.assignment.sahibinden.entity.enums.HISTORICAL_ENTITY_STATUS;
import com.eren.assignment.sahibinden.exception.ResponseCodes;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.exception.ServiceRuntimeException;
import com.eren.assignment.sahibinden.service.BeverageService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BeverageServiceImpl implements BeverageService {

	@Autowired
	BeverageDao beverageDao;

	public List<Beverage> getAllBeverages() {
		return beverageDao.getAllBeverages();
	}

	public Beverage getBeverage(long id) {
		return (Beverage) beverageDao.findById(id);
	}

	public Beverage getActiveBeverage(long id) {
		Beverage beverage = getBeverage(id);
		if (null == beverage || beverage.isActive() == false) {
			throw new ServiceRuntimeException(ResponseCodes.ITEMS_DEACTIVATED);
		}
		return beverage;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse createNewBeverage(Beverage beverage) {
		Beverage existingBeverage = beverageDao.getBeverageWithName(beverage.getName());

		// do not create if a beverage with same name already exists
		if (null == beverage.getId() && null != existingBeverage) {
			throw new ServiceRuntimeException(ResponseCodes.ENTITY_NAME_ALREADY_EXISTS);
		}

		beverage.setId(null);
		beverage.setCdate(new Date());
		beverage.setStatus(HISTORICAL_ENTITY_STATUS.ACTIVE.getCode());
		beverageDao.save(beverage);
		return ServiceResponse.getSuccessIstance();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse updateBeverage(Beverage beverage) {
		// TODO set uuserid
		long beverageId = beverage.getId();

		// create new updated beverage
		// beverage.setId(0);
		beverage.setCdate(new Date());
		beverage.setCuserId((long) 1);
		createNewBeverage(beverage);

		// deactivate existing beverage
		removeBeverage(beverageId);

		return ServiceResponse.getSuccessIstance();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse removeBeverage(long id) {
		Beverage existingBeverage = getBeverage(id);
		// check if id not found
		if (null == existingBeverage
				|| HISTORICAL_ENTITY_STATUS.DEACTIVE.getCode().equals(existingBeverage.getStatus())) {
			return new ServiceResponse(ResponseCodes.ENTITY_NOT_FOUND);
		}

		existingBeverage.setUdate(new Date());
		existingBeverage.setUuserId((long) 1);
		existingBeverage.setStatus(HISTORICAL_ENTITY_STATUS.DEACTIVE.getCode());
		beverageDao.update(existingBeverage);

		return ServiceResponse.getSuccessIstance();
	}

}
