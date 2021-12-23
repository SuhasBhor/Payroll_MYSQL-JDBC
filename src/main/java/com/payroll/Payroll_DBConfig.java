package com.payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import java.sql.Driver;

public class Payroll_DBConfig {
	static String URL = "jdbc:mysql://localhost:3306/payroll_services";
	static String USER = "root";
	static String PASSWORD = "Suhas#3799";
	static Connection connection;

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // For Load Driver
		System.out.println("Driver Loaded");

		ListDrivers();

		try {
			System.out.println("Connecting To Database " + URL);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected Successfully " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void ListDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
		}
	}
}