package com.atul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.atul.model.User;

public class signinDao {
	String url = "jdbc:mysql://localhost:3306/notes";
	String username = "root";
	String password = "root";
	Connection con;
	Statement st;
	public boolean insert(User user) throws SQLException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			st=con.createStatement();
			int result=st.executeUpdate("insert into login(uname,pass) values('"+user.getName()+"','"+user.getPassword()+"');");
			if(result==1) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
//			con.close();
		}
		return false;
	}
}
