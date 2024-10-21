package com.hexaware.ams.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

		public static Connection getDBConnection() {
			
			Connection conn =null;
			
			try {

				FileReader reader = new FileReader("resources/DBConfig.properties");

				Properties prop = new Properties();

				prop.load(reader);

				String driver = prop.getProperty("driver.classname");
				String url = prop.getProperty("url");
				String username = prop.getProperty("user");
				String password = prop.getProperty("password");

				Class.forName(driver);

				conn = DriverManager.getConnection(url,username,password);

			} catch (SQLException e) {

			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			return conn;

		}

	}



