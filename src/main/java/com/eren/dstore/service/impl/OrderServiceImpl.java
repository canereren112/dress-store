package com.eren.dstore.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eren.dstore.dao.OrderDao;
import com.eren.dstore.dao.OrderItemDao;
import com.eren.dstore.dao.OrderItemDetailDao;
import com.eren.dstore.entity.Order;
import com.eren.dstore.entity.OrderItem;
import com.eren.dstore.entity.OrderItemDetail;
import com.eren.dstore.exception.ResponseCodes;
import com.eren.dstore.exception.ServiceResponse;
import com.eren.dstore.exception.ServiceRuntimeException;
import com.eren.dstore.service.OrderService;
import com.eren.dstore.service.model.EntityStats;
import com.eren.dstore.service.model.ShoppingCart;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	OrderItemDao orderItemDao;

	@Autowired
	OrderItemDetailDao orderItemDetailDao;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ServiceResponse checkoutOrder(ShoppingCart cart) {
		// TODO get user from session
		// create order
		// User user = userService.getUser(3);
		// Order order = cart.getOrder();

		// return message if cart is empty
		if (cart.isEmpty()) {
			throw new ServiceRuntimeException(ResponseCodes.CART_IS_EMPTY);
		}

		Order order = createOrder(cart.getOrder());

		// create OrderItems
		for (OrderItem orderItem : cart.getOrder().getOrderItems()) {
			orderItem.setOrder(order);
			createOrderItem(orderItem);

			// create OrderItemDetails
			for (OrderItemDetail orderItemDetail : orderItem.getOrderItemDetails()) {
				createOrderItemDetail(orderItemDetail);
			}
		}

		// invalidate shopping cart session object
		cart.clear();

		return ServiceResponse.getSuccessIstance();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void createOrderItemDetail(OrderItemDetail orderItemDetail) {
		orderItemDetail.setId(null);
		orderItemDetailDao.save(orderItemDetail);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void createOrderItem(OrderItem orderItem) {
		orderItem.setId(null);
		orderItemDao.save(orderItem);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private Order createOrder(Order order) {
		order.setId(null);
		order.setCdate(new Date());
		orderDao.save(order);
		return order;
	}

	//TODO sonucu sifir olanlari da dondur
	public List<EntityStats> getStatsforUsers() {
		return orderDao.getStatsforUsers();
	}

	//TODO sonucu sifir olanlari da dondur
	public List<EntityStats> getStatsforBeverages() {
		return orderItemDao.getStatsforBeverages();
	}

	//TODO sonucu sifir olanlari da dondur
	public List<EntityStats> getStatsforCondiments() {
		return orderItemDetailDao.getStatsforCondiments();
	}

}
