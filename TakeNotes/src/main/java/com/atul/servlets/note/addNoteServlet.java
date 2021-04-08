package com.atul.servlets.note;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import com.atul.dao.NoteDao;
import com.atul.model.Note;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addNote")
public class addNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		Note note = new Note();
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setUid(user.getId());
		
		Long milis=System.currentTimeMillis();
		Date date = new Date(milis);
		note.setDate(date);
		
		System.out.print("Date is::"+note.getDate());
		
		NoteDao noteDao=new NoteDao();
		
		try {
			if(noteDao.insertNote(note)) {
				System.out.println("Inserted.");
//				session.setAttribute("note", note);
				response.sendRedirect("showNote");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
