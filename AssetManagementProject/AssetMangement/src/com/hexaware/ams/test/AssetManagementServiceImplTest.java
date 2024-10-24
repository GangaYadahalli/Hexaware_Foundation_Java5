package com.hexaware.ams.test;
/*
 * @Author:Ganga & Shriya
 * Desp:  Testing implementation
 * Date: 21st Oct 24
 */
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hexaware.ams.entity.*;
import com.hexaware.ams.exception.AssetNotFoundException;
import com.hexaware.ams.service.AssetManagementServiceImpl;
import com.hexaware.ams.service.IAssetManagementService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

class AssetManagementServiceImplTest {
	static IAssetManagementService service;
	@BeforeAll  
	public static void beforeAll() {
		
		service = new AssetManagementServiceImpl();
		
	}
	
	
	@Test
	void testAddAsset() {

		Date date=Date.valueOf("2023-02-28");
	    Assets asset = new Assets(11, "chair", "Furniture", 1020, date, "Office", "inuse", 103);
	    boolean count=false;
	    try {
	        count = service.addAsset(asset);
	        assertTrue(count, "The maintenanceRecords should be added successfully");
	        System.out.println("maintenanceRecords added successfully");
	    } catch (Exception e) {
	        System.err.println("Error occurred while adding maintenance records: " + e.getMessage());
	    }
//	    boolean count = service.addAsset(asset);
//
//	    assertTrue(count, "The asset should be added successfully");
//	    System.out.println("asset added successfully");
	}

//	@Test
//	void testPerformMaintenance()
//	{
//		Date date=Date.valueOf("2023-11-28");
//		boolean count=service.performMaintenance(4,date, "DeskRepair",5000.0);
//		
//		assertTrue(count,"The maintenanceRecords should be added successfully");
//		System.out.println("maintenanceRecords added successfully");
//	}
//	
//	@Test
//	void testReserveAsset()
//	{
//		Date reservationDate=Date.valueOf("2024-02-28");
//		Date startDate=Date.valueOf("2024-06-25");
//		Date endDate=Date.valueOf("2024-06-27");
//		
//		
//		boolean count=service.reserveAsset(1, 101, reservationDate, startDate, endDate, "approved");
//		
//		assertTrue(count,"The reservation should be added successfully");
//		System.out.println("reservation added successfully");
//		
//		
//	}
//
//	@Test
//	void testDeleteAsset_AssetNotFound() {
//	int assetId = 39;  
//    boolean exceptionThrown = false;
//    try {
//       
//        service.deleteAsset(assetId);
//    } catch (AssetNotFoundException e) {
//        exceptionThrown = true;
//        
//        System.err.println("Exception caught: " + e.getMessage());
//        assertEquals("Invalid Asset ID: " + assetId, e.getMessage());
//    }
//    assertTrue(exceptionThrown, "AssetNotFoundException should be thrown for non-existent asset ID");
//    
//
//	}
}


