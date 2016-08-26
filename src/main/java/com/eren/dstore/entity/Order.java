package com.eren.assignment.sahibinden.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {

	@ManyToOne
	@JoinColumn
	private User user;

	private long totalCost;

	private long reducedCost;

	/** The create date. */
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date cdate;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	@JsonManagedReference("order_item")
	private List<OrderItem> orderItems;

	private static final long serialVersionUID = 1L;

	public Order() {
		super();
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public long getReducedCost() {
		return reducedCost;
	}

	public void setReducedCost(long reducedCost) {
		this.reducedCost = reducedCost;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [user=" + user.getUserName() + ", totalCost=" + totalCost + ", cdate=" + cdate + ", getId()="
				+ getId() + "]";
	}

}
