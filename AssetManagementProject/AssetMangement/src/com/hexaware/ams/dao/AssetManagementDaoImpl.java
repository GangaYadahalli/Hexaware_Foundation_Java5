package com.hexaware.ams.dao;
/*
 * @Author:Ganga & Shriya
 * Desp:  Dao implementation for all the methods 
 * Date: 21st Oct 24
 */
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hexaware.ams.entity.AssetAllocation;
import com.hexaware.ams.entity.Assets;
import com.hexaware.ams.entity.MaintenanceRecords;
import com.hexaware.ams.entity.Reservations;
import com.mysql.cj.xdevapi.Statement;

public class AssetManagementDaoImpl implements IAssetManagementDao{
	
    Connection conn;
	//connection is used to establish and manage a connection
	public AssetManagementDaoImpl()
	{
		conn=DBUtil.getDBConnection();
	}
	
	//adding a new assets to Assets table
	@Override
	public boolean addAsset(Assets asset) {
		int  count=0;
		String insert="insert into Assets (assetId, name, type, serialNumber,purchaseDate, location ,status,ownerId) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1,asset.getAssetId());
			pstmt.setString(2, asset.getName());
			pstmt.setString(3, asset.getType());
			pstmt.setInt(4,asset.getSerialNumber());
			pstmt.setDate(5, asset.getPurchaseDate());
			pstmt.setString(6,asset.getLocation());
			pstmt.setString(7,asset.getStatus());
			pstmt.setInt(8, asset.getOwnerId());
			
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
	}
	//updating asset name of a particular assetId
	@Override
	public boolean updateAsset(Assets asset) {
		int count=0;
		String update="update Assets set name=? where assetId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(update);
			pstmt.setString(1, asset.getName());
			pstmt.setInt(2,asset.getAssetId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
	}
	//delete asset from assets of a particular assetId
	@Override
	public boolean deleteAsset(int assetId) {
		
		int count=0;
		String delete="delete from Assets where assetId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(delete);
			
			pstmt.setInt(1,assetId);
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
		
	}
	//adding a new assets to AssetAllocation table
	@Override
	public boolean allocateAsset(int assetId, int employeeId, Date allocationDate) {
		
		int  count=0;
		String  allocate="insert into AssetAllocation (assetId,employeeId,allocationDate) values(?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(allocate);
			
			pstmt.setInt(1,assetId);
			pstmt.setInt(2, employeeId);
			pstmt.setDate(3, allocationDate);
		
			
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
	}
	//deleting from AssetAllocation table based on a particular returnDate
	@Override
	public boolean deallocateAsset(int assetId, int employeeId, Date returnDate) {
		
		int count=0;
		String deallocate="delete from AssetAllocation where returnDate=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(deallocate);
			
			pstmt.setDate(1,returnDate);
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
	}
	//delete from Reservations table of a particular reservationId
	@Override
	public boolean withdrawReservation(int reservationId) {
		int count=0;
		String withdraw="delete from reservations where reservationId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(withdraw);
			
			pstmt.setInt(1,reservationId);
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
		
		
	}
	//adding a new assets into MaintenanceRecords table
	@Override
	public boolean performMaintenance(int assetId, Date maintenanceDate, String description, double cost) {
		int  count=0;
		String insert="insert into MaintenanceRecords (assetId,maintenanceDate, description ,cost) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1,assetId);
			pstmt.setDate(2, maintenanceDate);
			pstmt.setString(3, description);
			pstmt.setDouble(4,cost);
			
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
		
	}

	//adding a new assets into Reservations table
	@Override
	public boolean reserveAsset(int assetId, int employeeId, Date reservationDate, Date startDate, Date endDate,
			String status) {
		
		int  count=0;
		String insert="insert into Reservations (assetId,employeeId, reservationDate ,startDate,endDate,status) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			
			pstmt.setInt(1,assetId);
			pstmt.setInt(2,employeeId);
			pstmt.setDate(3, reservationDate);
			pstmt.setDate(4,startDate);
			pstmt.setDate(5,endDate);
			pstmt.setString(6, status);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		boolean result = (count != 0); 
		return result;
	}

	//Retrieving the maintenanceDate that is not maintained for 2 years 
	@Override
	public boolean maintenanceDate(MaintenanceRecords assetId) {
		String checkDate = "SELECT maintenancedate FROM maintenancerecords WHERE assetid = ? ORDER BY maintenancedate DESC LIMIT 1;";
		
        try (PreparedStatement checkDateStmt = conn.prepareStatement(checkDate)) {
            try {
            	
				checkDateStmt.setInt(1,assetId.getAssetId());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
            ResultSet result = null;
			try {
				result = checkDateStmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}

            try {
				if (result.next()) {
				    Date lastMaintenanceDate = result.getDate("maintenancedate");

				    if (lastMaintenanceDate != null) {
				        Calendar maintenanceCal = Calendar.getInstance();
				        maintenanceCal.setTime(lastMaintenanceDate);
				        Calendar currentCal = Calendar.getInstance();

				        int yearDifference = currentCal.get(Calendar.YEAR) - maintenanceCal.get(Calendar.YEAR);
				        if (yearDifference > 2 || (yearDifference == 2 && currentCal.get(Calendar.DAY_OF_YEAR) >= maintenanceCal.get(Calendar.DAY_OF_YEAR))) {
				            return false; 
				        } else {
				            return true;  
				        }
				    }
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        }

catch (SQLException e1) {

e1.printStackTrace();
}
		return false;

}

}




	
	


	

