package com.hexaware.electronics.entity;

import java.sql.Date;

public class Orders {
	private int orderId;
	private Customer customerId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	
	public Orders() {
		super();
	}
	
	public Orders(int orderId, Customer customerId, Date orderDate, double totalAmount,String status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status=status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomer(Customer customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}

	

	


}

