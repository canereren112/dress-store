/**
 * 
 */
package com.eren.assignment.sahibinden.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eren.assignment.sahibinden.entity.OrderItem;
import com.eren.assignment.sahibinden.entity.OrderItemDetail;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.service.model.ShoppingCart;

import junit.framework.Assert;

/**
 * 
 * Sepet islemleri
 * @author firat
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:**/servlet-context.xml")
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartServiceTest {
	public final String USER_NAME = "user";

	private static ShoppingCart cart;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	OrderService orderService;

	@Autowired
	private BeverageService beverageService;

	@Autowired
	CondimentService condimentService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cart = new ShoppingCart();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sepete ekleme test senaryosu
	 * Test method for
	 * {@link com.eren.assignment.sahibinden.service.ShoppingCartService#addToCart(java.lang.String, com.eren.assignment.sahibinden.service.model.ShoppingCart, com.eren.assignment.sahibinden.entity.OrderItem)}.
	 */
	@Test
	public void testAddToCart() throws Exception {
		cart = shoppingCartService.addToCart(USER_NAME, cart, createOrderItem());

		Assert.assertEquals(USER_NAME, cart.getOrder().getUser().getUserName());
		Assert.assertNotNull(cart.getOrder().getOrderItems().get(0).getBeverage().getName());

	}

	/**
	 * Sepetten cikarma test senaryosu
	 * Test method for
	 * {@link com.eren.assignment.sahibinden.service.ShoppingCartService#removeFromCart(com.eren.assignment.sahibinden.service.model.ShoppingCart, int)}.
	 */
	@Test
	public void testRemoveFromCart() throws Exception {
		int size = cart.getOrder().getOrderItems().size();
		cart = shoppingCartService.removeFromCart(cart, 0);
		int newSize = cart.getOrder().getOrderItems().size();
		Assert.assertEquals(newSize + 1, size);
	}
	
	
	/**
	 * Sepeti satin alma test senaryosu
	 * Test method for
	 * {@link com.eren.assignment.sahibinden.service.ShoppingCartService#removeFromCart(com.eren.assignment.sahibinden.service.model.ShoppingCart, int)}.
	 */
	@Test
	public void checkoutOrder() throws Exception {
		testAddToCart();
		testAddToCart();
		
		ServiceResponse serviceResponse = orderService.checkoutOrder(cart);
		Assert.assertEquals(serviceResponse.getErrorCode(), 0);
		Assert.assertNull(cart.getOrder().getUser());
	}

	private OrderItem createOrderItem() {
		OrderItem OrderItem = new OrderItem();
		OrderItem orderItem = new OrderItem();
		orderItem.setBeverage(beverageService.getBeverage(1));

		List<OrderItemDetail> OrderItemDetails = new ArrayList<OrderItemDetail>();
		OrderItemDetail OrderItemDetail = new OrderItemDetail();
		OrderItemDetail.setCondiment(condimentService.getCondiment(1));
		OrderItemDetail.setCount(2);
		OrderItemDetail.setOrderItem(orderItem);
		OrderItemDetails.add(OrderItemDetail);

		orderItem.setOrderItemDetails(OrderItemDetails);
		return orderItem;
	}

}
