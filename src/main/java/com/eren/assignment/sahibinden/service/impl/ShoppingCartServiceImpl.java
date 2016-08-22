package com.eren.assignment.sahibinden.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eren.assignment.sahibinden.entity.Beverage;
import com.eren.assignment.sahibinden.entity.Condiment;
import com.eren.assignment.sahibinden.entity.Order;
import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.entity.OrderItemDetail;
import com.eren.assignment.sahibinden.entity.User;
import com.eren.assignment.sahibinden.exception.ResponseCodes;
import com.eren.assignment.sahibinden.exception.ServiceRuntimeException;
import com.eren.assignment.sahibinden.service.BeverageService;
import com.eren.assignment.sahibinden.service.CondimentService;
import com.eren.assignment.sahibinden.service.ShoppingCartService;
import com.eren.assignment.sahibinden.service.UserService;
import com.eren.assignment.sahibinden.service.discount.DiscountService;
import com.eren.assignment.sahibinden.service.model.ShoppingCart;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	UserService userService;

	@Autowired
	BeverageService beverageService;

	@Autowired
	CondimentService condimentService;

	@Autowired
	List<DiscountService> discountServices;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ShoppingCart addToCart(String userName, ShoppingCart cart, OrderItem orderItem) {
		User user = userService.getUserWithUserName(userName);
		cart.addToCart(user, orderItem);
		return finalizeCart(cart);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ShoppingCart removeFromCart(ShoppingCart cart, int orderItemIndex) {
		cart.removeFromCart(orderItemIndex);
		return finalizeCart(cart);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private ShoppingCart finalizeCart(ShoppingCart cart) {
		// calculate all necessary computations for costs
		cart = calculateCosts(cart);

		cart = calculateDiscountCost(cart);
		return cart;
	}

	private ShoppingCart calculateDiscountCost(ShoppingCart cart) {
		long discountCost = 0;
		for (DiscountService discountService : discountServices) {
			discountCost = Math.max(discountCost, discountService.getDiscountCost(cart));
		}
		cart.getOrder().setReducedCost(cart.getOrder().getTotalCost() - discountCost);
		return cart;
	}

	private ShoppingCart calculateCosts(ShoppingCart cart) {
		Order order = cart.getOrder();

		// total cost for the whole order
		long orderCost = 0;

		for (OrderItem orderItem : order.getOrderItems()) {
			if (null == orderItem.getBeverage()) {
				// clear cart session object
				cart.clear();
				throw new ServiceRuntimeException(ResponseCodes.CART_IS_UNSTABLE);
			}

			// get the beverage entity from db
			Beverage beverage = beverageService.getActiveBeverage(orderItem.getBeverage().getId());
			orderItem.setBeverage(beverage);

			// calculate total cost for each order item (beverage and
			// condiments)
			long orderItemCost = beverage.getCost();
			for (OrderItemDetail orderItemDetail : orderItem.getOrderItemDetails()) {
				if (null == orderItemDetail.getCondiment()) {
					// clear cart session object
					cart.clear();
					throw new ServiceRuntimeException(ResponseCodes.CART_IS_UNSTABLE);
				}

				// get the condiment entity from db
				Condiment condiment = condimentService.getActiveCondiment(orderItemDetail.getCondiment().getId());
				orderItemDetail.setCondiment(condiment);

				orderItemCost += orderItemDetail.getItemDetailCost();
			}
			orderItem.setTotalCost(orderItemCost);

			orderCost += orderItemCost;
		}
		order.setTotalCost(orderCost);

		return cart;
	}

}
