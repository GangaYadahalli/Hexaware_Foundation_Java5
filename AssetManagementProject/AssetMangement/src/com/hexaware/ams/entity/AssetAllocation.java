package com.hexaware.ams.entity;

import java.sql.Date;

public class AssetAllocation {
	//attributes of AssetAllocation class
	private int allocationId;
	private int assetId;
	private int employeeId;
	private Date allocationDate;
	private Date returnDate;
	
	
//default constructor
	public AssetAllocation() {
		super();
	}


//paratemetrized constructors
	public AssetAllocation(int allocationId, int assetId, int employeeId, Date allocationDate, Date returnDate) {
		super();
		this.allocationId = allocationId;
		this.assetId = assetId;
		this.employeeId = employeeId;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
	}


//setter getter methods
	public int getAllocationId() {
		return allocationId;
	}



	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}



	public int getAssetId() {
		return assetId;
	}



	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public Date getAllocationDate() {
		return allocationDate;
	}



	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}



	public Date getReturnDate() {
		return returnDate;
	}



	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
//tostring method
	@Override
	public String toString() {
		return "AssetAllocation [allocationId=" + allocationId + ", assetId=" + assetId + ", employeeId=" + employeeId
				+ ", allocationDate=" + allocationDate + ", returnDate=" + returnDate + "]";
	}



}
