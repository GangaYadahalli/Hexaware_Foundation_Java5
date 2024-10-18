package com.hexaware.electronics.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.electronics.entity.Customer;
import com.hexaware.electronics.entity.Inventory;
import com.hexaware.electronics.entity.OrderDetails;
import com.hexaware.electronics.entity.Orders;
import com.hexaware.electronics.entity.Product;
import com.hexaware.electronics.exception.InvalidDataException;

public class ElectronicGadgetsDaoImpl implements IElectronicGadgetsDao{

	  Connection conn;
		
		public ElectronicGadgetsDaoImpl()
		{
			conn=DBUtil.getDBConnection();
		}

		@Override
		public int CalculateTotalOrders() {
			  int orderCount=0;
		    String selectOrderCounts = "SELECT sum(orderCount) as count  FROM Customer;";  

		    try {
		        PreparedStatement pstmt = conn.prepareStatement(selectOrderCounts);
		        
		        ResultSet rs = pstmt.executeQuery();

		        while (rs.next()) {
		             orderCount = rs.getInt(1);  
		              
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return orderCount;  
		
		}
	@Override
	public List<Customer> GetCustomerDetails(int customerId) {
		 {
	        List<Customer> customers = new ArrayList<>();
	        String query = "SELECT * FROM Customer WHERE customerId = ?";

	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, customerId);
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                // Create Appointment object for each result and add it to the list
	                Customer customer = new Customer(
	                	 rs.getInt("customerId"),
	        				rs.getString("FirstName"),
	        				rs.getString("LastName"),
	        				rs.getString("Email"),
	        				rs.getString("Phone"),
        				rs.getString("Address"),
	        				rs.getInt("OrderCount"))
	        				;
	                        
	               
	                customers.add(customer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return customers; // Return the list of appointments (can be empty if none found)
	    }
	}
//		List<Customer>  list = new ArrayList<Customer>();
//		String selectAll = "select *  from Customer ";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(selectAll);
//
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				int customerId = rs.getInt("customerId");
//				String FirstName=rs.getString("FirstName");
//				String LastName=rs.getString("LastName");
//				String Email=rs.getString("Email");
//				String Phone=rs.getString("Phone");
//				String Address=rs.getString("Address");
//				int OrderCount=rs.getInt("OrderCount");
////				int OrderId=rs.getInt("OrderId");
//				
//				
//			Customer  cus = new Customer(customerId,FirstName,LastName,Email,Phone,Address,OrderCount);
//
//					list.add(cus);
//			}
//
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return list;
	

	@Override
	public int UpdateCustomerInfo(Customer cus) {
		int count=0;
		String update="update Customer set FirstName=? where customerId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setString(1, cus.getFirstName());
			pstmt.setInt(2,cus.getCustomerId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Product> GetProductDetails() {
		List<Product>  list = new ArrayList<Product>();
		String selectAll = "select *  from Product ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int ProductId = rs.getInt("productId");
				String ProductName=rs.getString("ProductName");
				String Description=rs.getString("Description");
				double Price=rs.getDouble("Price");
				//String Categories=rs.getString("Categories");
						
			Product  pro = new Product(ProductId,ProductName,Description,Price);
					list.add(pro);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int UpdateProductInfo(Product pro) {
		
		int count=0;
		String update="update Product set productName=? where productId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setString(1, pro.getProductName());
			pstmt.setInt(2,pro.getProductId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public List<Orders> GetOrderDetails() {
		List<Orders>  list = new ArrayList<Orders>();
		String selectAll = "select *  from Orders ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int orderId = rs.getInt("orderId");
				int customerId = rs.getInt("customerId");
				Date orderDate=rs.getDate("OrderDate");
				double totalAmount=rs.getDouble("TotalAmount");
				String status=rs.getString("Status");
				
	            Customer customer = new Customer();
	            customer.setCustomerId(customerId);  
						
			Orders  ord =new Orders(orderId,customer,orderDate,totalAmount,status);
					list.add(ord);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int UpdateOrderStatus(Orders ord) {
		int count=0;
		String update="update Orders set status=? where orderId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setString(1, ord.getStatus());
			pstmt.setInt(2,ord.getOrderId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int CancelOrder(int orderId) {
		
		int count=0;
		String deallocate="delete from Orders where orderId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(deallocate);
			
			pstmt.setInt(1,orderId);
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
		return count;
	}
	@Override
	public List<OrderDetails> GetOrderDetailInfo() {
		
		List<OrderDetails>  list = new ArrayList<OrderDetails>();
		String selectAll = "select *  from OrderDetails ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int orderDetailId = rs.getInt("orderDetailId");
				int orderId = rs.getInt("orderId");
				int productId=rs.getInt("ProductId");
				int quantity=rs.getInt("Quantity");
				
				Orders order = new Orders();
	            order.setOrderId(orderId); 
	            Product product = new Product();
	            product.setProductId(productId); 
						
			OrderDetails  ord =new OrderDetails(orderDetailId,order,product,quantity);
					list.add(ord);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int UpdateQuantity(OrderDetails ordDs) {
		int count=0;
		String update="update OrderDetails set quantity=? where orderDetailId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setInt(1, ordDs.getQuantity());
			pstmt.setInt(2,ordDs.getOrderDetailId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int CalculateSubtotal() {
		int orderCount=0;
	    String selectOrderCounts = "SELECT sum(quantity) as count  FROM OrderDetails;";  

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(selectOrderCounts);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	             orderCount = rs.getInt(1);  
	              
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return orderCount; 
	}

	@Override
	public int RemoveFromInventory(int quantityInStock) {
		int count=0;
		String deallocate="delete from inventory where quantityInStock=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(deallocate);
			
			pstmt.setInt(1,quantityInStock);
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
		return count;
		
	}

	@Override
	public int UpdateStockQuantity(Inventory inventory) {
		int count=0;
		String update="update inventory set QuantityInStock=? where inventoryId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setInt(1, inventory.getQuantityInStock()); 
		    pstmt.setInt(2, inventory.getInventoryId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int IsProductInStock() {
		int OrderCount=0;
		
		String select="SELECT COUNT(*) FROM Product WHERE productId = ?";
		try {
	        PreparedStatement pstmt = conn.prepareStatement(select);
	        
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	             OrderCount = rs.getInt(1);  
	              
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 	OrderCount;
	}

	@Override
	public int CalculateTotalAmount() {
		int TotalAmount=0;
	    String selectTotalAmoount = "SELECT sum(TotalAmount) as count  FROM Orders;";  

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(selectTotalAmoount);
	        
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	        	TotalAmount = rs.getInt(1);  
	              
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return TotalAmount;  
	
		
	}

	@Override
	public List<Inventory> ListAllProducts() {
		List<Inventory>  list = new ArrayList<Inventory>();
		String selectAll = "select *  from Inventory ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int  InventoryID = rs.getInt("InventoryID");
				int  productID = rs.getInt("ProductID");
				int QuantityInStock=rs.getInt("QuantityInStock");
				Date LastStockUpdate=rs.getDate("LastStockUpdate");
	            
	            Product product=new Product(); 
	            product.setProductId(productID);
			Inventory  inv =new Inventory(InventoryID,product,QuantityInStock,LastStockUpdate);
					list.add(inv);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int IsProductAvailable(int QuantityInStock) {
        int count =0;
        PreparedStatement pstmt;
		String select="SELECT * FROM Inventory WHERE QuantityInStock = ?";
	
		try {
	        pstmt = conn.prepareStatement(select);
	        pstmt.setInt(1, QuantityInStock);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	           count = rs.getInt(1);  
	              
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 	count;
	    
	}

	@Override
	public int GetQuantityInStock(int productId) {
		int count =0;
        PreparedStatement pstmt;
		String select="SELECT QuantityInStock FROM Inventory WHERE productId = ?";
	
		try {
	        pstmt = conn.prepareStatement(select);
	        pstmt.setInt(1, productId);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	           count = rs.getInt(1);  
	              
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 	count;
	}

	@Override
	public int GetProduct(int inventoryId) {
		int count =0;
        PreparedStatement pstmt;
		String select="SELECT ProductId FROM Inventory WHERE  InventoryId = ?";
	
		try {
	        pstmt = conn.prepareStatement(select);
	        pstmt.setInt(1, inventoryId);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	           count = rs.getInt(1);  
	              
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 	count;
	    
	
	}

	@Override
	public List<Inventory> ListOutOfStockProducts() {
		
		    List<Inventory> outOfStockProducts = new ArrayList<>();
		    String query = "SELECT * FROM Inventory WHERE QuantityInStock =0";

		    try (
		         PreparedStatement pstmt = conn.prepareStatement(query);
		         ResultSet rs = pstmt.executeQuery()) {

		        while (rs.next()) {
		            int inventoryId = rs.getInt("InventoryID");
		            int productId = rs.getInt("ProductID");
		            int quantityInStock = rs.getInt("QuantityInStock");
		            Date lastStockUpdate = rs.getDate("LastStockUpdate");

		            Product product = new Product();
		            product.setProductId(productId);

		            Inventory inv = new Inventory(inventoryId, product, quantityInStock, lastStockUpdate);
		            outOfStockProducts.add(inv);
		        }
		    } catch (SQLException e) {
		        System.out.println("Error retrieving out of stock products: " + e.getMessage());
		    }

		    return outOfStockProducts;
		}

	@Override
	public Customer getByEmail(String email) {

		String selectOne = "select * from Customer where email = ?";
		PreparedStatement pstmt;

		Customer cus = null;
		try {
			pstmt = conn.prepareStatement(selectOne);

					pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int customerId = rs.getInt("customerId");
				String FirstName=rs.getString("FirstName");
				String LastName=rs.getString("LastName");
				String Email=rs.getString("Email");
				String Phone=rs.getString("Phone");
				String Address=rs.getString("Address");
				int OrderCount=rs.getInt("OrderCount");
				  cus = new Customer(customerId,FirstName,LastName,Email,Phone,Address,OrderCount);

			
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return cus;
	}

	@Override
	public OrderDetails getByOrderDetail(int OrderDetailId) {
		
		return null;
	}


	    
	
	}

	





		
	
	



