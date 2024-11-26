package com.app.jdbc.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.post.dao.PostDAO;


public class PostUpdate extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDAO postDAO = new PostDAO();
		Long id =Long.valueOf(req.getParameter("id"));
		req.setAttribute("post", postDAO.selectById(id));
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}
