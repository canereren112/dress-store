package com.eren.assignment.sahibinden.service.discount;

import com.eren.assignment.sahibinden.service.model.ShoppingCart;

/**
 * Discount for total cost exceeding limit
 * 
 * @author firat.eren
 */
public class CostExceedLimitDiscountService extends DiscountService {
	private final long COST_LIMIT;
	private final double DISCOUNT_PERCENTAGE;

	public CostExceedLimitDiscountService(long costLimit, double discountPercentage) {
		COST_LIMIT = costLimit;
		DISCOUNT_PERCENTAGE = discountPercentage;
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
		return (long) (cart.getOrder().getTotalCost() * DISCOUNT_PERCENTAGE);
	}

	/**
	 * Check if total cost exceeds limit.
	 *
	 * @param cart
	 *            the cart
	 * @return true, if successful
	 */
	public boolean hasDiscount(ShoppingCart cart) {
		if (cart.getOrder().getTotalCost() >= COST_LIMIT) {
			return true;
		}
		return false;
	}
}
