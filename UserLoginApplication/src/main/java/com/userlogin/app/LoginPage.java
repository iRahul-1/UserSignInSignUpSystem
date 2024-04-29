package com.userlogin.app;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/ulogin")
public class LoginPage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("psw");
		UserBean login = new LoginDao().login(name, pass);
		if(login==null) {
			req.setAttribute("msg","User Not Found...");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ServletContext s = req.getServletContext();
			s.setAttribute("ubean", login);
			Cookie ck = new Cookie("uname", login.getUsername());
			res.addCookie(ck);
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}
}
