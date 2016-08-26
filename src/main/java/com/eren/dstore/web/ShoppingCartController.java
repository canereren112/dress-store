package com.eren.assignment.sahibinden.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.service.BeverageService;
import com.eren.assignment.sahibinden.service.CondimentService;
import com.eren.assignment.sahibinden.service.OrderService;
import com.eren.assignment.sahibinden.service.ShoppingCartService;
import com.eren.assignment.sahibinden.service.model.ShoppingCart;

@RestController
@Scope("request")
public class ShoppingCartController extends BaseController {
	@Autowired
	private ShoppingCart cart;

	@Autowired
	OrderService orderService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@RequestMapping(value = "/cart/", method = RequestMethod.GET)
	public ShoppingCart getCart() {
		return cart;
	}

	@RequestMapping(value = "/cart/items", method = RequestMethod.POST)
	public ShoppingCart addToCart(Principal user, @RequestBody OrderItem orderItem) {
		cart = shoppingCartService.addToCart(user.getName(), cart, orderItem);
		return cart;
	}

	@RequestMapping(value = "/cart/items/{orderItemIndex}", method = RequestMethod.DELETE)
	public ShoppingCart removeFromCart(@PathVariable int orderItemIndex) {
		cart = shoppingCartService.removeFromCart(cart, orderItemIndex);
		return cart;
	}

	@RequestMapping(value = "/cart/orders", method = RequestMethod.POST)
	public ServiceResponse checkoutOrder() {
		orderService.checkoutOrder(cart);
		return ServiceResponse.getSuccessIstance();
	}

}