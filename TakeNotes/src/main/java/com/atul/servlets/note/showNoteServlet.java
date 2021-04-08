package com.atul.servlets.note;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.atul.dao.NoteDao;
import com.atul.model.Note;
import com.atul.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showNote")
public class showNoteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
		}
		else {
			User user=(User)session.getAttribute("user");

			PrintWriter out=response.getWriter();
			String search=request.getParameter("search");
			
			NoteDao noteDao=new NoteDao();
			List<Note> list = noteDao.showAllNotes(user.getId(),search);
			if(list!=null) {
				for (Note n : list) {
					out.println(n.getTitle()+" : "+n.getContent());
				}
				session.setAttribute("list", list);
				response.sendRedirect("showNotes.jsp");
			}
		}
	}
}
