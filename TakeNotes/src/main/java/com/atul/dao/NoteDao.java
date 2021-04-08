package com.atul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atul.model.Note;

public class NoteDao {
	String url = "jdbc:mysql://localhost:3306/notes";
	String username = "root";
	String password = "root";
	Connection con;

	public NoteDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean insertNote(Note note) throws SQLException {
		Statement st;
		try {
			st = con.createStatement();
			int result = st.executeUpdate("insert into note(uid,title,content,date) values(" + note.getUid() + ",'"
					+ note.getTitle().trim() + "','" + note.getContent().trim() + "','"+note.getDate()+"');");
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Note> showAllNotes(int user_id, String search) {
		try {
			if (search==null) {
				search="";
			}
			System.out.println(search);
			String query = "select * from note where uid=? and title like '%" + search + "%';";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, user_id);
			ResultSet rs = st.executeQuery();
			System.out.println("Id: " + user_id);
			List<Note> myList = new ArrayList<>();

			while (rs.next()) {
				String title, content;
				int nid,uid;
				LocalDate localDate;
				Date date;
				uid=rs.getInt("uid");
				nid=rs.getInt("nid");
				title = rs.getString("title");
				content = rs.getString("content");
				date=rs.getDate("date");
				
				Note note = new Note();
				note.setUid(uid);
				note.setNid(nid);
				note.setTitle(title);
				note.setContent(content);
				note.setDate(date);;
				myList.add(note);
			}
			return myList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteNote(int note_id,int uid) {
		boolean isDeleted=false;
		try {
			String query="delete from note where uid=? and nid=?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, uid);
			st.setInt(2, note_id);
			int d=st.executeUpdate();
			if (d>0) {
				isDeleted=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isDeleted;
	}

	public Note getNote(int uid, int nid) {
		try {
			String query = "select * from note where uid=? and nid=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, uid);
			st.setInt(2, nid);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Note note=new Note();
				note.setUid(rs.getInt("uid"));
				note.setNid(rs.getInt("nid"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				note.setDate(rs.getDate("date"));
				return note;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	//To update a note
	public boolean deleteAddNote(Note note) {
		try {
			
			String deleteQuery = "delete from note where uid=? and nid=?";
			String addQuery = "insert into note values("+note.getUid()+","+note.getNid()+",'"+note.getTitle().trim()
								+"','"+note.getContent().trim()+"','"+note.getDate()+"');";
			PreparedStatement st=con.prepareStatement(deleteQuery);
			st.setInt(1, note.getUid());
			st.setInt(2, note.getNid());
			
			int delete = st.executeUpdate();
			if (delete==1) {
				Statement s=con.createStatement();
				int add=s.executeUpdate(addQuery);
				if (add==1) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
