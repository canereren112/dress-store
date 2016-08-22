package com.eren.assignment.sahibinden.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eren.assignment.sahibinden.dao.CondimentDao;
import com.eren.assignment.sahibinden.entity.Condiment;
import com.eren.assignment.sahibinden.entity.enums.HISTORICAL_ENTITY_STATUS;
import com.eren.assignment.sahibinden.exception.ResponseCodes;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.exception.ServiceRuntimeException;
import com.eren.assignment.sahibinden.service.CondimentService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CondimentServiceImpl implements CondimentService {

	@Autowired
	CondimentDao condimentDao;

	public List<Condiment> getAllCondiments() {
		return condimentDao.getAllCondiments();
	}

	public Condiment getCondiment(long id) {
		return (Condiment) condimentDao.findById(id);
	}

	public Condiment getActiveCondiment(long id) {
		Condiment condiment = getCondiment(id);
		if (null == condiment || condiment.isActive() == false) {
			throw new ServiceRuntimeException(ResponseCodes.ITEMS_DEACTIVATED);
		}
		return condiment;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse createNewCondiment(Condiment condiment) {
		Condiment existingCondiment = condimentDao.getCondimentWithName(condiment.getName());

		// do not create if a Condiment with same name already exists
		if (null == condiment.getId() && null != existingCondiment) {
			throw new ServiceRuntimeException(ResponseCodes.ENTITY_NAME_ALREADY_EXISTS);
		}

		condiment.setId(null);
		condiment.setCdate(new Date());
		condiment.setStatus(HISTORICAL_ENTITY_STATUS.ACTIVE.getCode());
		condimentDao.save(condiment);
		return ServiceResponse.getSuccessIstance();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse updateCondiment(Condiment condiment) {
		// TODO set uuserid
		long CondimentId = condiment.getId();

		// create new updated Condiment
		// Condiment.setId(0);
		condiment.setCdate(new Date());
		condiment.setCuserId((long) 1);
		createNewCondiment(condiment);

		// deactivate existing Condiment
		removeCondiment(CondimentId);

		return ServiceResponse.getSuccessIstance();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse removeCondiment(long id) {
		Condiment existingCondiment = getCondiment(id);
		// check if id not found
		if (null == existingCondiment
				|| HISTORICAL_ENTITY_STATUS.DEACTIVE.getCode().equals(existingCondiment.getStatus())) {
			return new ServiceResponse(ResponseCodes.ENTITY_NOT_FOUND);
		}

		existingCondiment.setUdate(new Date());
		existingCondiment.setUuserId((long) 1);
		existingCondiment.setStatus(HISTORICAL_ENTITY_STATUS.DEACTIVE.getCode());
		condimentDao.update(existingCondiment);

		return ServiceResponse.getSuccessIstance();
	}

}
