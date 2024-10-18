package com.hexaware.electronics.dao;

import java.util.List;

import com.hexaware.electronics.entity.Customer;
import com.hexaware.electronics.entity.Inventory;
import com.hexaware.electronics.entity.OrderDetails;
import com.hexaware.electronics.entity.Orders;
import com.hexaware.electronics.entity.Product;
import com.hexaware.electronics.exception.InvalidDataException;

public interface IElectronicGadgetsDao {
	int CalculateTotalOrders();
	List<Customer> GetCustomerDetails(int customerId);
	int UpdateCustomerInfo(Customer cus);
	
	
	Customer getByEmail(String email) ;
	OrderDetails getByOrderDetail(int orderDetailId);
//	Inventory getByEmail(String email) ;
	
	
	
	 List<Product> GetProductDetails();
	 int UpdateProductInfo(Product pro);
	 int IsProductInStock();
	 
	 
	 
	 List<Orders> GetOrderDetails();
	 int UpdateOrderStatus(Orders ord);
	 int CancelOrder(int orderId);
	
	 int CalculateTotalAmount();
	 List<OrderDetails> GetOrderDetailInfo();
	 int UpdateQuantity(OrderDetails ordDs);
	 
	 int GetProduct(int inventoryId );
	int GetQuantityInStock(int productId);
	 int CalculateSubtotal();
	 int RemoveFromInventory(int quantityInStock);
	 int UpdateStockQuantity(Inventory inventory);
	 int IsProductAvailable(int QuantityInStock);
	 List<Inventory>  ListAllProducts();
	 List<Inventory>  ListOutOfStockProducts();
}
