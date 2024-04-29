package com.userlogin.app;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@SuppressWarnings("serial")
@WebServlet("/register")
public class UserRegistration extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try {
		Connection con = DBConnection.getcon();
		PreparedStatement register = con.prepareStatement("insert into users values(?,?,?,?,?)");
		register.setString(1, req.getParameter("name"));
		register.setString(2, req.getParameter("password"));
		register.setLong(3, Long.parseLong(req.getParameter("phone")));
		register.setString(4, req.getParameter("email"));
		register.setString(5, "address");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int k = register.executeUpdate();
		if(k>0) {
			pw.println("User added successfully...");
			req.getRequestDispatcher("Login.html").forward(req, res);
		}else {
			pw.println("Registration failed");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
