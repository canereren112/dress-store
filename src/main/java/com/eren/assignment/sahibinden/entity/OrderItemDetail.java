package com.eren.assignment.sahibinden.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.eren.assignment.sahibinden.entity.BaseEntity;
import com.eren.assignment.sahibinden.entity.Condiment;
import com.eren.assignment.sahibinden.entity.OrderItem;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: OrderContiments
 *
 */
@Entity
public class OrderItemDetail extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn
	@JsonBackReference("order_condiment")
	private OrderItem orderItem;

	@ManyToOne
	@JoinColumn
	private Condiment condiment;

	@Column(name = "itemCount")
	private int count;

	public OrderItemDetail() {
		super();
	}

	public OrderItem getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Condiment getCondiment() {
		return this.condiment;
	}

	public void setCondiment(Condiment condiment) {
		this.condiment = condiment;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

//	@Transient
	public long getItemDetailCost() {
		return condiment.getCost() * count;
	}

	@Override
	public String toString() {
		return "OrderContiments [orderItem=" + orderItem.getId() + ", beverage=" + orderItem.getBeverage().getName()
				+ ", condiment=" + condiment.getName() + ", getId()=" + getId() + "]";
	}

}
