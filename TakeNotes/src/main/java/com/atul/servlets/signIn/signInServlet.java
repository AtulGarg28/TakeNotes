package com.atul.servlets.signIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.atul.dao.signinDao;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signIn")
public class signInServlet extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String name=request.getParameter("username");
//		String pass=request.getParameter("password");
		User user=new User();
		user.setName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		signinDao signinDao=new signinDao();
		boolean status=false;
		try {
			status = signinDao.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if (status) {
			out.println("Added");
		}
		else {
			out.println("Not added");
		}
		
		
	}

}
