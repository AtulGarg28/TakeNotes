package com.atul.servlets.note;

import java.io.IOException;

import com.atul.dao.NoteDao;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteNote")
public class deleteNoteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
		}else {
			User user = (User)session.getAttribute("user");
			
			int note_id=Integer.parseInt(request.getParameter("note_id").trim());
			System.out.println(note_id);
			NoteDao noteDao=new NoteDao();
			boolean status = noteDao.deleteNote(note_id, user.getId());
			if (status) {
				System.out.println("Deleted.");
			}else {
				System.out.println("Deletion failed.");
			}
		}
		response.sendRedirect("showNote");
	}
}
