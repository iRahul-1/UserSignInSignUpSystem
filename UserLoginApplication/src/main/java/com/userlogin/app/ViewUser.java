package com.userlogin.app;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/View")
public class ViewUser extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie [] ck = req.getCookies();
	if(ck==null) {
		req.setAttribute("msg", "Session Expired!!");
		req.getRequestDispatcher("uLogin").forward(req, resp);
	}else {
		ServletContext sc = req.getServletContext();
		UserBean ub = (UserBean) sc.getAttribute("ubean");
		req.setAttribute("bean", ub);
		String name = ck[0].getValue();
		req.setAttribute("msg", name);
		req.getRequestDispatcher("view.jsp").forward(req, resp);
	}
}
}
