package com.atul.servlets.login;

import java.io.IOException;

import com.atul.dao.loginDao;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user=new User();
		user.setName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		loginDao loginDao=new loginDao();
		User user2 = loginDao.check(user);
		if(user2!=null){
			user.setId(user2.getId());
			System.out.println("Login successful with password: "+user.getPassword());
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}