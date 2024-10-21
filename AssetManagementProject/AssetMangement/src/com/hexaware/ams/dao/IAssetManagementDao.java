package com.hexaware.ams.dao;

import java.sql.Date;
/*
 * @Author: Ganga & Shriya
 * @Description: IAssetManagementDao is an interface
 * Date: 21st Oct 2024
 */
import java.util.List;

import com.hexaware.ams.entity.Assets;
import com.hexaware.ams.entity.MaintenanceRecords;
import com.hexaware.ams.entity.Reservations;
import com.hexaware.ams.exception.AssetNotMaintainException;

public interface IAssetManagementDao {
	
    boolean addAsset(Assets asset);
	
	boolean updateAsset(Assets asset);
	
	 boolean deleteAsset(int assetId);
	 
	 boolean allocateAsset(int assetId, int employeeId, Date allocationDate);
	 
	 boolean deallocateAsset(int assetId, int employeeId, Date returnDate);
	 
	 boolean performMaintenance(int assetId, Date maintenanceDate, String description, double cost);
		
	 boolean reserveAsset(int assetId, int employeeId, Date reservationDate, Date startDate, Date endDate,String status);
	 
	 boolean withdrawReservation(int reservationId);
	 
	 boolean maintenanceDate(MaintenanceRecords assetId);

}
