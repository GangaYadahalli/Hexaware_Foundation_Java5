package com.hexaware.electronics.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Inventory {
	
	private int inventoryId;
	private Product product;
	private int quantityInStock;
	private Date lastStockUpdate;
	

	public Inventory() {
		super();
	}


	public Inventory(int inventoryId,Product product, int quantityInStock, Date lastStockUpdate) {
		super();
		this.inventoryId = inventoryId;
		this.product = product;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
	}

	public int getInventoryId() {
		return inventoryId;
	}


	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantityInStock() {
		return quantityInStock;
	}


	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}


	public Date getLastStockUpdate() {
		return lastStockUpdate;
	}


	public void setLastStockUpdate(Date lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}


	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", product=" + product + ", quantityInStock=" + quantityInStock
				+ ", lastStockUpdate=" + lastStockUpdate + "]";
	}
	


}

