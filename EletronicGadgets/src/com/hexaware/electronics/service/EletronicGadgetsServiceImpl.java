package com.hexaware.electronics.service;

import java.util.List;

import com.hexaware.electronics.dao.ElectronicGadgetsDaoImpl;
import com.hexaware.electronics.dao.IElectronicGadgetsDao;
import com.hexaware.electronics.entity.Customer;
import com.hexaware.electronics.entity.Inventory;
import com.hexaware.electronics.entity.OrderDetails;
import com.hexaware.electronics.entity.Orders;
import com.hexaware.electronics.entity.Product;
import com.hexaware.electronics.exception.IncompleteOrderException;
import com.hexaware.electronics.exception.InvalidDataException;

public class EletronicGadgetsServiceImpl implements IElectronicGadgetsService {

	private IElectronicGadgetsDao dao;
	public EletronicGadgetsServiceImpl()
	{
		dao=new ElectronicGadgetsDaoImpl();
		
	}
	@Override
	public int CalculateTotalOrders() {
		
		return dao.CalculateTotalOrders();
	}

	@Override
	public List<Customer> GetCustomerDetails(int customerId) {
		
		return dao.GetCustomerDetails(customerId);	}
	@Override
	public int UpdateCustomerInfo(Customer cus) {
		
		return dao.UpdateCustomerInfo(cus);
	}
	@Override
	public List<Product> GetProductDetails() {
		
		return dao.GetProductDetails();
	}
	@Override
	public int UpdateProductInfo(Product pro) {
		
		return dao.UpdateProductInfo(pro);
	}
	@Override
	public List<Orders> GetOrderDetails() {
		
		return dao.GetOrderDetails();
	}
	@Override
	public int UpdateOrderStatus(Orders ord) {
		
		return dao.UpdateOrderStatus(ord);
	}
	@Override
	public int CancelOrder(int orderId) {
		
		return dao.CancelOrder(orderId);
	}
	@Override
	public List<OrderDetails> GetOrderDetailInfo() {
		
		return dao.GetOrderDetailInfo();
	}
	
	@Override
	public int UpdateQuantity(OrderDetails ordDs) {
		
		return dao.UpdateQuantity(ordDs);
	}

	
	
	
	
	
	
	
	public static boolean validateCustomerUpdate(Customer cus)
	{
		boolean flag=false;

		if(cus.getCustomerId()>100 && cus.getFirstName().length()>3 ) {
			
			flag=true;
		}
		return flag;
	}
	public static boolean validateProduct(Product pro)
	{
		boolean flag=false;

		if(pro.getProductId()>0 && pro.getProductName().length()>3 ) {
			
			flag=true;
		}
		return flag;
	}
	public static boolean validateOrderUpdate(Orders ord)
	{
		boolean flag=false;

		if(ord.getOrderId()>200 ) {
			
			flag=true;
		}
		return flag;
	}
	public static boolean validateOrderCancel(Orders ord)
	{
		boolean flag=false;

		if(ord.getOrderId()>200 ) {
			
			flag=true;
		}
		return flag;
	}
	public static boolean validateOrderDetailsUpdate(OrderDetails ordDs)
	{
		boolean flag=false;

		if(ordDs.getOrderDetailId()>1000 && ordDs.getQuantity()>0) {
			
			flag=true;
		}
		return flag;
	}
	@Override
	public int CalculateSubtotal() {
		
		return dao.CalculateSubtotal();
	}
	@Override
	public int RemoveFromInventory(int quantityInStock) {
		
		return dao.RemoveFromInventory(quantityInStock);
	}
	
	
	public static boolean validateInventory(Inventory inv)
	{
		boolean flag=false;

		if(inv.getQuantityInStock()>0&& inv.getInventoryId()>2000 ) {
			
			flag=true;
		}
		return flag;
	}
	@Override
	public int UpdateStockQuantity(Inventory inventory) {
		
		return dao.UpdateStockQuantity(inventory);
	}
	@Override
	public int IsProductInStock() {
		
		return dao.IsProductInStock();
	}
	@Override
	public int CalculateTotalAmount() {
		
		return dao.CalculateTotalAmount();
	}
	@Override
	public List<Inventory> ListAllProducts() {
		
		return dao.ListAllProducts();
	}
	@Override
	public int IsProductAvailable(int QuantityInStock) {
		
		return dao.IsProductAvailable(QuantityInStock);
	}
	@Override
	public int GetQuantityInStock(int productId) {
		
		return dao.GetQuantityInStock(productId);
	}
	@Override
	public int GetProduct(int inventoryId) {
		
		return dao.GetProduct(inventoryId);
	}
	@Override
	public List<Inventory> ListOutOfStockProducts() {
		
		return dao.ListOutOfStockProducts();
	}

	@Override
	public Customer getByEmail(String email) throws InvalidDataException {
		Customer cus = dao.getByEmail(email);

		if (cus == null) {

			try {

				throw new InvalidDataException();

			} catch (Exception e) {

				System.err.println("Customer Not Found Email " + email);
			}

		}
		return cus;
	}
	@Override
	public OrderDetails getByOrderDetail(int orderDetailId) throws IncompleteOrderException {
		OrderDetails ord = dao.getByOrderDetail(orderDetailId);

		if (ord == null) {

			try {

				throw new IncompleteOrderException();

			} catch (Exception e) {

				System.err.println("OrderDetails Not Found of orderDetailId :" + orderDetailId);
			}

		}
		return ord;
	
	}
	

	
	
}

