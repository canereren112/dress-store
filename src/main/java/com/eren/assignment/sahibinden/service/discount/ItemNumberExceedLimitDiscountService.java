package com.eren.assignment.sahibinden.service.discount;

import java.util.Comparator;

import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.service.model.ShoppingCart;

/**
 * Discount for item number exceeding limit
 * 
 * @author firat.eren
 */
public class ItemNumberExceedLimitDiscountService extends DiscountService {
	private final long ITEM_NUMBER_LIMIT;

	public ItemNumberExceedLimitDiscountService(long itemNumberLimit) {
		ITEM_NUMBER_LIMIT = itemNumberLimit;
	}

	/**
	 * Calculate discount cost.
	 *
	 * @param hasDiscount
	 *            the has discount
	 * @param cart
	 *            the cart
	 * @return the long
	 */
	public long calculateDiscountCost(ShoppingCart cart) {
		Comparator<OrderItem> comp = (i, j) -> Long.compare(i.getTotalCost(), j.getTotalCost());
		OrderItem cheapestOrderItem = cart.getOrder().getOrderItems().stream().min(comp).get();
		return cheapestOrderItem.getTotalCost();

	}

	/**
	 * Check if number of items exceeds limit.
	 *
	 * @param cart
	 *            the cart
	 * @return true, if successful
	 */
	public boolean hasDiscount(ShoppingCart cart) {
		if (cart.getOrder().getOrderItems().size() >= ITEM_NUMBER_LIMIT) {
			return true;
		}
		return false;
	}
}
