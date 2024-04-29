package com.userlogin.app;
import java.sql.*;
public class DBConnection {
	static String dbUrl="jdbc:oracle:thin:@localhost:1521:xe";
	static String uName="rahul";
	static String pwd="rahul";
	static Connection con=null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dbUrl,uName,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getcon() {
		return con;
	}
}
