package com.eren.assignment.sahibinden.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: OrderItem
 *
 */
@Entity
public class OrderItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn
	@JsonBackReference("order_item")
	private Order order;

	@ManyToOne
	@JoinColumn
	private Beverage beverage;

	@OneToMany(mappedBy = "orderItem", fetch = FetchType.LAZY)
	@JsonManagedReference("order_condiment")
	private List<OrderItemDetail> orderItemDetails;

	private long totalCost;

	public OrderItem() {
		super();
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Beverage getBeverage() {
		return this.beverage;
	}

	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public List<OrderItemDetail> getOrderItemDetails() {
		return orderItemDetails;
	}

	public void setOrderItemDetails(List<OrderItemDetail> orderItemDetails) {
		this.orderItemDetails = orderItemDetails;
	}

	@Override
	public String toString() {
		return "OrderItem [order=" + (order != null ? order.getId() : 0) + ", beverage=" + beverage.getName()
				+ ", getId()=" + getId() + "]";
	}

}
