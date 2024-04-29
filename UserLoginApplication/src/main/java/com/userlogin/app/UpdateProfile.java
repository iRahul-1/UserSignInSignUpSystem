package com.userlogin.app;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class UpdateProfile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c [] = req.getCookies();
		if(c==null) {
			req.setAttribute("msg", "Session Expired!! <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			
		}else {
			String name = c[0].getName();
			req.setAttribute("name", name);
			req.getRequestDispatcher("UpdateProfile.jsp").forward(req, resp);
		}
	}
}
