package com.eren.dstore.service;

import com.eren.dstore.entity.OrderItem;
import com.eren.dstore.service.model.ShoppingCart;

public interface ShoppingCartService {

	public ShoppingCart addToCart(String userName, ShoppingCart cart, OrderItem orderItem);

	public ShoppingCart removeFromCart(ShoppingCart cart, int orderItemIndex);

}
