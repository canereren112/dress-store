package com.eren.assignment.sahibinden.service;

import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.service.model.ShoppingCart;

public interface ShoppingCartService {

	public ShoppingCart addToCart(String userName, ShoppingCart cart, OrderItem orderItem);

	public ShoppingCart removeFromCart(ShoppingCart cart, int orderItemIndex);

}
