package com.atul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atul.model.User;

public class loginDao {
	String url="jdbc:mysql://localhost:3306/notes";
	String username="root";
	String password="root";
	String query="select * from login where uname=? and pass=?";
	public User check(User user) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, user.getName());
			st.setString(2, user.getPassword());
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				user.setId(Integer.parseInt(rs.getString(1)));
				return user;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
