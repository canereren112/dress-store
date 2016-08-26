package com.eren.dstore.base;

import java.util.HashSet;
import java.util.Set;

import com.eren.dstore.entity.Beverage;

public class OrderDecorator extends Beverage {
	int totalCost;
	Beverage beverage;
//	Set<Beverage> beverages = new HashSet<Beverage>();
 
   public OrderDecorator(Beverage beverage) {
		// TODO Auto-generated constructor stub
	}
}
