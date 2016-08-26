package com.eren.assignment.sahibinden.service.model;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.eren.assignment.sahibinden.entity.Order;
import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Scope("session")
public class ShoppingCart {
	private Order order;

	public ShoppingCart() {
		clear();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@JsonIgnore
	public boolean isEmpty() {
		if (null == order || CollectionUtils.isEmpty(order.getOrderItems())) {
			return true;
		}
		return false;
	}

	// invalidate shopping cart session object
	public void clear() {
		order = new Order();
		order.setOrderItems(new ArrayList<OrderItem>());
	}

	public void addToCart(User user, OrderItem orderItem) {
		order.setUser(user);
		order.getOrderItems().add(orderItem);
	}

	public void removeFromCart(int orderItemIndex) {
		if (order.getOrderItems().size() > orderItemIndex) {
			order.getOrderItems().remove(orderItemIndex);
		}
	}
}
