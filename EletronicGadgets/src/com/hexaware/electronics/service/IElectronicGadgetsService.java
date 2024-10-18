package com.hexaware.electronics.service;

import java.util.List;

import com.hexaware.electronics.entity.Customer;
import com.hexaware.electronics.entity.Inventory;
import com.hexaware.electronics.entity.OrderDetails;
import com.hexaware.electronics.entity.Orders;
import com.hexaware.electronics.entity.Product;
import com.hexaware.electronics.exception.IncompleteOrderException;
import com.hexaware.electronics.exception.InvalidDataException;

public interface IElectronicGadgetsService {
	int CalculateTotalOrders();
	List<Customer> GetCustomerDetails(int customerId);
	int UpdateCustomerInfo(Customer cus);
	Customer getByEmail(String email) throws InvalidDataException;
	
	//boolean processOrder(Long productId, int orderQuantity);
	
	OrderDetails getByOrderDetail(int orderDetailId) throws  IncompleteOrderException;
	
	List<Product> GetProductDetails();
	int UpdateProductInfo(Product pro);
	int IsProductInStock();
	
	int CalculateTotalAmount();
	List<Orders> GetOrderDetails();
	
	int UpdateOrderStatus(Orders ord);
	int CancelOrder(int orderId);
	
	
	int CalculateSubtotal();
	List<OrderDetails> GetOrderDetailInfo();
	 int UpdateQuantity(OrderDetails ordDs);
	 
	 int GetProduct(int inventoryId );
	 int GetQuantityInStock(int productId);
	 int RemoveFromInventory(int quantityInStock);
	 int UpdateStockQuantity(Inventory inventory);
	 int IsProductAvailable(int QuantityInStock);
	 List<Inventory>  ListAllProducts();
	 List<Inventory>  ListOutOfStockProducts();
	 
	
	 
	 
	 
}
