package com.hexaware.electronics.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hexaware.electronics.service.IElectronicGadgetsService;
import com.hexaware.electronics.entity.Customer;
import com.hexaware.electronics.entity.Inventory;
import com.hexaware.electronics.entity.OrderDetails;
import com.hexaware.electronics.entity.Orders;
import com.hexaware.electronics.entity.Product;
import com.hexaware.electronics.exception.InvalidDataException;
import com.hexaware.electronics.service.EletronicGadgetsServiceImpl;

public class EletronicGadgetsApp {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws InvalidDataException {

		boolean flag = true;

		IElectronicGadgetsService service = new EletronicGadgetsServiceImpl();
		while (flag) {

			System.out.println("*****Welcome to Eletronics Gadgets *****");
			System.out.println("1. Total of orders");
			System.out.println("2.SHOW ALL customers");
			System.out.println("3.UPDATE customers");
			System.out.println("4.Show all products");
			System.out.println("5. Update products");
			System.out.println("6.show all orders");
			System.out.println("7.Update status of orders");
			System.out.println("8.Cancel order");
			System.out.println("9.Show all orderdetails");
			System.out.println("10.Update OrderDetails quantity");
			System.out.println("11.Show quantity instock");
			System.out.println("12.Total of quantity");
			System.out.println("13.Delete from inventory");
			System.out.println("14.Update inventory");
			System.out.println("15.Check if product exists ");
			System.out.println("16.Calculate TotalAmoount");
			System.out.println("17.list all products from inventory");
			System.out.println("18.Is product available");
			System.out.println("19.check qunatity in stock");
			System.out.println("20.Get the Product");
			System.out.println("21.List where quantityInstock is 0");
			System.out.println("22.Email validation");
			System.out.println("0. EXIT  / LOGOUT");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				
				int  success = service.CalculateTotalOrders();
		      
		            System.out.println(success);
		        
				
			case 2:
				System.out.println("Enter customerId");
				int customerId=scanner.nextInt();
				List<Customer> list1 = service.GetCustomerDetails(customerId);

				for (Customer customer1 : list1) {

					System.out.println(customer1);

				}
				break;

			case 3:
				Customer Update=updateCustomerData();
				boolean isValid1 = EletronicGadgetsServiceImpl.validateCustomerUpdate(Update);
				if (isValid1) {
					int count = service.UpdateCustomerInfo(Update);
					
					if (count> 0) {
						System.out.println("update successfully..");	
					}
					else {
						System.err.println("update  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;

			case 4:
				List<Product> list2 = service.GetProductDetails();

				for (Product product : list2) {

					System.out.println(product);

				}

				break;
			case 5:
				Product Update1=updateProductData();
				boolean isValid2 = EletronicGadgetsServiceImpl.validateProduct(Update1);
				if (isValid2) {
					int count = service.UpdateProductInfo(Update1);
					
					if (count> 0) {
						System.out.println("update successfully..");	
					}
					else {
						System.err.println("update  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;
				
			case 6:
				List<Orders> list3 = service.GetOrderDetails();

				for (Orders orders : list3) {

					System.out.println(orders);

				}

				break;
			case 7:
				Orders UpdateOrd=updateOrderData();
				boolean isValid3 = EletronicGadgetsServiceImpl.validateOrderUpdate(UpdateOrd);
				if (isValid3) {
					int count = service.UpdateOrderStatus(UpdateOrd);
					
					if (count> 0) {
						System.out.println("update successfully..");	
					}
					else {
						System.err.println("update  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;
			case 8:
				Orders delete=deleteOrdersData();
				boolean isValid4 = EletronicGadgetsServiceImpl.validateOrderCancel(delete);
				if (isValid4) {
					int count = service.CancelOrder(delete.getOrderId());
				  if (count > 0) {
						System.out.println("Delete successfully..");
						//System.out.println(count);
					}

					else {

						System.err.println("Delete  Failed...");

					}

				} else {

					System.err.println("Invalid  Data");

				}
				break;
			case 9:
				List<OrderDetails> orderDetailsList= service.GetOrderDetailInfo();
					
				 List<String> resultList = new ArrayList<>();

				    for ( OrderDetails ord : orderDetailsList) {
				        String OrdersDetails  = "	OrderDeatilsID: " + ord.getOrderDetailId() + 
				                                  ", ProductID: " + ord.getProduct().getProductId() + 
				                                  ", Quantity " + ord.getQuantity() + 
				                                  ", OrderID: " + ord.getOrder().getOrderId() ;
				        
				        resultList.add(OrdersDetails);
				    }		
				    for (String OrdersDetails  : resultList) {
			            System.out.println(OrdersDetails );
			        }break;
				
			case 10:
				OrderDetails UpdateOrderDetails=updateOrderDetailsData();
				boolean isValid5= EletronicGadgetsServiceImpl.validateOrderDetailsUpdate(UpdateOrderDetails);
				if (isValid5) {
					int count = service.UpdateQuantity(UpdateOrderDetails);
					
					if (count> 0) {
						System.out.println("update successfully..");	
					}
					else {
						System.err.println("update  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;
			case 12:
				int  success2 = service.CalculateSubtotal();
			      
	            System.out.println(success2);
	            break;
			case 13:
				Inventory delete1=deleteInventoryData();
				boolean isValid6 = EletronicGadgetsServiceImpl.validateInventory(delete1);
				if (isValid6) {
					int count = service.RemoveFromInventory(delete1.getQuantityInStock());
				  if (count > 0) {
						System.out.println("Delete successfully..");
					}

					else {

						System.err.println("Delete  Failed...");

					}

				} else {

					System.err.println("Invalid  Data");

				}
				break;
			case 14:
				Inventory UpdateInventory=updateInventoryData();
				boolean isValid7= EletronicGadgetsServiceImpl.validateInventory(UpdateInventory);
				if (isValid7) {
					int count = service.UpdateStockQuantity(UpdateInventory);
					
					if (count> 0) {
						System.out.println("update successfully..");	
					}
					else {
						System.err.println("update  Failed...");
					}
				} else {
					System.err.println("Invalid  Data");
				}
				break;
				
			case 15:
			      
				int  success1 = service.IsProductInStock();
			      
	            System.out.println(success1);
				
				break;
			case 16:
				int  success3 = service.CalculateTotalAmount();
			      
	            System.out.println(success3);
				
				break;
			case 17:
				 List<Inventory> inventoryList =service.ListAllProducts();
				
				 List<String> resultList1 = new ArrayList<>();

				    for (Inventory inv : inventoryList) {
				        String inventoryDetails = "InventoryID: " + inv.getInventoryId() + 
				                                  ", ProductID: " + inv.getProduct().getProductId() + 
				                                  ", QuantityInStock: " + inv.getQuantityInStock() + 
				                                  ", LastStockUpdate: " + inv.getLastStockUpdate();
				        
				        resultList1.add(inventoryDetails);
				    }		
				    for (String inventoryDetails : resultList1) {
			            System.out.println(inventoryDetails);
			        }
				   break;
			case 18:
				System.out.println("Enter QuantityInStock to Search Inventory");

				int QuantityInStock=scanner.nextInt();
				
              int  available =	service.IsProductAvailable(QuantityInStock);
				System.out.println(available);
				break;
			case 19:
				System.out.println("Enter productId to Search Inventory");

				int productId=scanner.nextInt();
				
              int  quantity =	service.GetQuantityInStock(productId);
				System.out.println(quantity);
				break;
			case 20:
				System.out.println("Enter InventoryId to Search Inventory");

				int inventoryId=scanner.nextInt();
				
              int  checkProduct =	service.GetProduct(inventoryId);
				System.out.println(checkProduct);
				break;
			case 21:
		
				
				List<Inventory> outOfStockProducts = service.ListOutOfStockProducts();

		        if (outOfStockProducts.stream().count() ==0) {
		            System.out.println("No products are out of stock.");
		        } else {
		            System.out.println("Out of Stock Products:");
		            for (Inventory inv : outOfStockProducts) {
		                System.out.println("InventoryID: " + inv.getInventoryId() +
		                                   ", ProductID: " + inv.getProduct().getProductId() +
		                                   ", QuantityInStock: " + inv.getQuantityInStock() +
		                                   ", LastStockUpdate: " + inv.getLastStockUpdate());
		            }
		        }
				break;
			case 22:
				System.out.println("Enter Email to Search customer");

				String email =scanner.next();
				
			Customer cus =	service.getByEmail(email);
			
			if(cus != null)	
			System.out.println(cus);

		        break;
		        
			case 0:
					flag = false;
					
					System.out.println("Thank you , logout successfully..");
				
				
				break;

			default:
				break;
			}

		}

	}
	
	public static Customer updateCustomerData() {

		Customer cus = new Customer();
		
		System.out.println("Enter FirstName");
		cus.setFirstName(scanner.next());
		System.out.println("Enter CustomerId");
		cus.setCustomerId(scanner.nextInt());

		return cus;
	}
	public static Product updateProductData() {	
		Product pro = new Product();
		
		System.out.println("Enter ProductName");
		pro.setProductName(scanner.next());
		System.out.println("Enter ProductId");
		pro.setProductId(scanner.nextInt());

		return pro;
	}
	public static Orders updateOrderData() {	
		Orders ord = new Orders();
		
		System.out.println("Enter Status");
		ord.setStatus(scanner.next());
		System.out.println("Enter OrderId");
		ord.setOrderId(scanner.nextInt());

		return ord;
	}
	public static Orders deleteOrdersData() {	
		Orders ord = new Orders();

		System.out.println("Enter OrderId");
		ord.setOrderId(scanner.nextInt());

		return ord;
	}
	public static OrderDetails updateOrderDetailsData() {	
		OrderDetails ord = new OrderDetails();
		System.out.println("Enter Quantity");
		ord.setQuantity(scanner.nextInt());
		System.out.println("Enter OrderdeatilId");
		ord.setOrderDetailId(scanner.nextInt());

		return ord;
	}
	public static  Inventory CheckQuantityInStock() {	
		Inventory inv = new Inventory();
		Product pro=new Product();
		System.out.println("Enter ProductId");
		pro.setProductId(scanner.nextInt());
		inv.setProduct(pro);
		return inv;
	}
	public static  Inventory deleteInventoryData()
	{
		Inventory inv = new Inventory();
		System.out.println("Enter QuantityInStock");
	   inv.setQuantityInStock(scanner.nextInt());
	   
	   return inv;
	}
	public static  Inventory updateInventoryData(){
		Inventory inv = new Inventory();
		System.out.println("Enter QuantityInStock");
	   inv.setQuantityInStock(scanner.nextInt());
		System.out.println("Enter InventoryId");
		inv.setInventoryId(scanner.nextInt());
		return inv;
		
	}
	public static Product CheckProductData()
	{
		Product product=new Product();
		System.out.println("Enter ProductId");
		product.setProductId(scanner.nextInt());
		return product;
	}
}
