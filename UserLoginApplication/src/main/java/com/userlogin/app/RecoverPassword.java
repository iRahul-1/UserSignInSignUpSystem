package com.userlogin.app;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*; 
@SuppressWarnings("serial")
@WebServlet("/recover")
public class RecoverPassword extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			int k = RecoverPassworddao.recover(pass,email);
			if(k>0) {
				req.setAttribute("msg", "Password Changed...");
				req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}
	}
}
