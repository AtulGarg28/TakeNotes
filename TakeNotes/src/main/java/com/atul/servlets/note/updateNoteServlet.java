package com.atul.servlets.note;

import java.io.IOException;
import java.io.PrintWriter;

import com.atul.dao.NoteDao;
import com.atul.model.Note;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateNote")
public class updateNoteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp");
		}else {
			int note_id=Integer.parseInt(request.getParameter("note_id"));
			NoteDao noteDao=new NoteDao();
			Note note = noteDao.getNote(user.getId(), note_id);
			
			if (session.getAttribute("note") != null) {
				session.removeAttribute("note");
			}
			session.setAttribute("note", note);
			response.sendRedirect("updateNote.jsp");
		}
	}
}
