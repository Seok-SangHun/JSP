package com.app.jdbc.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.post.dao.PostDAO;


public class PostDeleteOk extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		PostDAO postDAO = new PostDAO();
		
		postDAO.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}