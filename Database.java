package com;

import java.sql.*;

public class Database 
{
	static Connection con;
	public static Connection dataConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","adi123");
			System.out.println("Database connected....");

		}catch(Exception e)
		{
			System.out.println("Error Database " +e);
		}
		return con;
	}
}
