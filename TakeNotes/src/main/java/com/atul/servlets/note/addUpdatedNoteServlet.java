package com.atul.servlets.note;

import java.io.IOException;
import java.sql.Date;

import com.atul.dao.NoteDao;
import com.atul.model.Note;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addUpdatedNote")
public class addUpdatedNoteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title.trim());
		System.out.println(content.trim());
		
		Long milis=System.currentTimeMillis();
		Date date = new Date(milis);
		
		Note note = (Note) session.getAttribute("note");
		note.setTitle(title);
		note.setContent(content);
		note.setDate(date);
		
		
		NoteDao noteDao=new NoteDao();
		noteDao.deleteAddNote(note);
		response.sendRedirect("showNote");
		
		System.out.println("Note id is::"+note.getNid());
		System.out.println("Note content is::"+note.getContent());
	}

}
