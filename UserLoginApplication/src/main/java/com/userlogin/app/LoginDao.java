package com.userlogin.app;
import java.sql.*;
public class LoginDao {
 public UserBean ub = null;
 public UserBean login(String name,String pass) {
	 try {
		 Connection con = DBConnection.getcon();
		 PreparedStatement login = con.prepareStatement("select * from users where name = ? and password = ?");
		 login.setString(1, name);
		 login.setString(2, pass);
		 ResultSet rs = login.executeQuery();
		 if(rs.next()) {
			 ub=new UserBean();
		     ub.setUsername(rs.getString(1));
		     ub.setPassword(rs.getString(2));
		     ub.setPhone(rs.getLong(3));
		     ub.setEmail(rs.getString(4));
		     ub.setAddress(rs.getString(5));
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ub;
 }
}
