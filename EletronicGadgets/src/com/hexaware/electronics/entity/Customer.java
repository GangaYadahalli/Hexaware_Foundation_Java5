package com.hexaware.electronics.entity;

public class Customer {
		
		private int customerId;
		private String firstName;
		private String lastName;
		private String email;
		private String phone;
		private String address;
		private int orderCount;
		
		
		

		public Customer() {
			super();
		}
		


		public Customer(int customerId, String firstName, String lastName, String email, String phone, String address,int orderCount) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.orderCount=orderCount;
		}

		public int getCustomerId() {
			return customerId;
		}



		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}



		public String getFirstName() {
			return firstName;
		}



		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}



		public String getLastName() {
			return lastName;
		}



		public void setLastName(String lastName) {
			this.lastName = lastName;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getPhone() {
			return phone;
		}



		public void setPhone(	String phone) {
			this.phone = phone;
		}



		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		public int getOrderCount() {
			return orderCount;
		}



		public void setOrderCount(int orderCount) {
			this.orderCount = orderCount;
		}



		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", orderCount=" + orderCount
					+ "]";
		}



		
	    

}
