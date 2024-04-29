package com.userlogin.app;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/newdata")
public class UpdateProfileServlet extends HttpServlet{
	@Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
 IOException{
	 Cookie c[] = req.getCookies();
	 if(c==null) {
		 req.setAttribute("msg", "Session Expired...<br>");
		 req.getRequestDispatcher("Msg.jsp").forward(req, res);
	 }else {
		String name = c[0].getValue();
		req.setAttribute("name", name);
		ServletContext sct = req.getServletContext();
		UserBean ub = (UserBean)sct.getAttribute("ubean");
		ub.setAddress(req.getParameter("addr"));
		ub.setEmail(req.getParameter("mid"));
		ub.setPhone(Long.parseLong(req.getParameter("phno")));
		int k = new UpdateProfileDaO().update(ub);
		if(k>0){
			req.setAttribute("msg", "Profile Updated Successfully...<br>");
			req.getRequestDispatcher("view.jsp").forward(req, res);
		}
	 }
 }
}

