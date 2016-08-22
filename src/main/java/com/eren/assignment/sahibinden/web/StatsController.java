package com.eren.assignment.sahibinden.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eren.assignment.sahibinden.entity.OrderItemDetail;
import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.service.BeverageService;
import com.eren.assignment.sahibinden.service.CondimentService;
import com.eren.assignment.sahibinden.service.OrderService;
import com.eren.assignment.sahibinden.service.model.EntityStats;

@RestController
public class StatsController extends BaseController {
	@Autowired
	OrderService orderService;

	@Autowired
	CondimentService condimentService;

	@Autowired
	BeverageService beverageService;

	@RequestMapping(value = "/stats/users", method = RequestMethod.GET)
	public List<EntityStats> getStatsforUsers() {
		return orderService.getStatsforUsers();

	}

	@RequestMapping(value = "/stats/beverages", method = RequestMethod.GET)
	public List<EntityStats> getStatsforBeverages() {
		return orderService.getStatsforBeverages();
	}

	@RequestMapping(value = "/stats/condiments", method = RequestMethod.GET)
	public List<EntityStats> getStatsforCondiments() {
		return orderService.getStatsforCondiments();
	}

	// TODO bunu mock test metodlarina yaz
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<OrderItem> getOrders() {
		// return condimentService.createNewCondiment(Condiment);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		OrderItem orderItem = new OrderItem();
		orderItem.setBeverage(beverageService.getBeverage(1));

		List<OrderItemDetail> orderCondiments = new ArrayList<OrderItemDetail>();
		OrderItemDetail orderCondiment = new OrderItemDetail();
		orderCondiment.setCondiment(condimentService.getCondiment(1));
		orderCondiment.setCount(2);
		orderCondiment.setOrderItem(orderItem);
		orderCondiments.add(orderCondiment);

		orderItem.setOrderItemDetails(orderCondiments);
		orderItems.add(orderItem);
		return orderItems;
	}
}
