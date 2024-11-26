package com.app.jdbc.post.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.post.dao.PostDAO;
import com.app.jdbc.post.vo.PostVO;


public class PostList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDAO postDAO = new PostDAO();
		List<PostVO> posts = postDAO.selectAll();
		
		req.setAttribute("posts", posts);
		req.getRequestDispatcher("post.jsp").forward(req, resp);
	}

}
