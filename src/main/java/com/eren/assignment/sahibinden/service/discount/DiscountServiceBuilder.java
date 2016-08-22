package com.eren.assignment.sahibinden.service.discount;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountServiceBuilder {

	@Autowired
	DiscountService costExceedLimitDiscountService;

	@Autowired
	DiscountService itemNumberExceedLimitDiscountService;

	@Bean
	public CostExceedLimitDiscountService costExceedLimitDiscountService() {
		return new CostExceedLimitDiscountService(12, 0.25);
	}

	@Bean
	public ItemNumberExceedLimitDiscountService itemNumberExceedLimitDiscountService() {
		return new ItemNumberExceedLimitDiscountService(3);
	}

	@Bean
	public List<DiscountService> discountServices() {
		return Arrays.asList(costExceedLimitDiscountService, itemNumberExceedLimitDiscountService);
	}
}