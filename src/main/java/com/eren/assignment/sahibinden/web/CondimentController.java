package com.eren.assignment.sahibinden.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eren.assignment.sahibinden.entity.Condiment;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.service.CondimentService;

@RestController
public class CondimentController extends BaseController {
	@Autowired
	CondimentService condimentService;

	@RequestMapping(value = "/condiments", method = RequestMethod.GET)
	public List<Condiment> getAllCondiments() {
		List<Condiment> Condiments = condimentService.getAllCondiments();
		return Condiments;
	}

	@RequestMapping(value = "/condiments/{id}", method = RequestMethod.GET)
	public Condiment getCondiment(@PathVariable int id) {
		return condimentService.getCondiment(id);
	}

	@RequestMapping(value = "/condiments", method = RequestMethod.POST)
	public ServiceResponse createNewCondiment(@RequestBody Condiment Condiment) {
		return condimentService.createNewCondiment(Condiment);
	}

	@RequestMapping(value = "/condiments/{id}", method = RequestMethod.PUT)
	public ServiceResponse updateCondiment(@PathVariable int id, @RequestBody Condiment Condiment) {
		return condimentService.updateCondiment(Condiment);
	}

	@RequestMapping(value = "/condiments/{id}", method = RequestMethod.DELETE)
	public ServiceResponse removeCondiment(@PathVariable int id) {
		return condimentService.removeCondiment(id);
	}

}
