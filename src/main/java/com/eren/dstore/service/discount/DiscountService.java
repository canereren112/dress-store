package com.eren.assignment.sahibinden.service.discount;

import com.eren.assignment.sahibinden.service.model.ShoppingCart;

/**
 * Generic Discount Service 
 * 
 * @author firat.eren
 */
public abstract class DiscountService {

	/**
	 * Gets the discount cost if discount criteria is accepted
	 *
	 * @param cart
	 *            the cart
	 * @return the discount cost
	 */
	public long getDiscountCost(ShoppingCart cart) {
		boolean hasDiscount = hasDiscount(cart);

		long cost = 0;
		if (hasDiscount) {
			cost = calculateDiscountCost(cart);
		}
		return cost;
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
	protected abstract long calculateDiscountCost(ShoppingCart cart);

	/**
	 * Checks for discount.
	 *
	 * @param cart
	 *            the cart
	 * @return true, if successful
	 */
	protected abstract boolean hasDiscount(ShoppingCart cart);
}
