package com.userlogin.app;

import java.sql.*;
public class UpdateProfileDaO {
   public int k=0;
   public int update(UserBean ub) {
	   try {
		   Connection con = DBConnection.getcon();
		   PreparedStatement ps = con.prepareStatement
				   ("update users set name=?,address = ?,phone=? where email=? and password=?");
		   ps.setString(1, ub.getUsername());
		   ps.setString(2, ub.getAddress());
		   ps.setLong(3, ub.getPhone());
		   ps.setString(4, ub.getEmail());
		   ps.setString(5, ub.password);
		   k = ps.executeUpdate();
	   }catch(Exception e) {
		   System.out.println(e.toString());
	   }
	   return k;
   }
}
