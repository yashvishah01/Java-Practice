package com.app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConnectionFactory {

	private static Properties properties = new Properties();
	
		static {
			
//			try {
//				FileInputStream fis = new FileInputStream("db.properties");
//				properties.load(fis);
//				fis.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
			//step 1: register
//			try {
//				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			
			try {
				//Class.forName(properties.getProperty("db.driver"));
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() throws SQLException {
//			String url = properties.getProperty("db.url");
//			String user = properties.getProperty("db.user");
//			String password = properties.getProperty("db.password");
			String url ="jdbc:oracle:thin:@localhost:1521/orcl";
			String user ="hr";
			String password ="hr";
			return DriverManager.getConnection(url, user, password);
		}
		
}
