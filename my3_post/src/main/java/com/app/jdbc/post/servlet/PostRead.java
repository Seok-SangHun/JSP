package com.app.jdbc.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.post.dao.PostDAO;
import com.app.jdbc.post.vo.PostVO;


public class PostRead extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDAO postDAO = new PostDAO();
		String input = req.getParameter("id");
		Long id = Long.valueOf(input);
		PostVO postVO = postDAO.selectById(id);
		req.setAttribute("post", postVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}
}
