package com.userlogin.app;
import java.sql.*;
public class RecoverPassworddao {
	public static int  recover(String pass,String email) {
		int k = 0;
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement update = con.prepareStatement("update users set password = ? where email = ?");
			update.setString(1, pass);
			update.setString(2, email);
			k = update.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}
}
