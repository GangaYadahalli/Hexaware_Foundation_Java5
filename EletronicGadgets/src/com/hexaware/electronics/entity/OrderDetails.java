package com.hexaware.electronics.entity;


public class OrderDetails {
	private int orderDetailId;
	private Orders order;
	private Product product;
	private int quantity;

	public OrderDetails() {
		super();
	}

	public OrderDetails(int orderDetailId, Orders order, Product product, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailId=" + orderDetailId + ", order=" + order + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
	

}

