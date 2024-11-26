package com.app.jdbc.post.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.post.dao.PostDAO;
import com.app.jdbc.post.vo.PostVO;


public class PostUpdateOk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	   
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("UTF-8");
	      Long id = Long.valueOf(req.getParameter("id"));
	      String postTitle = req.getParameter("postTitle");
	      int postLiked = Integer.parseInt(req.getParameter("postLiked"));
	      
	      PostDAO psotDAO = new PostDAO();
	      PostVO postVO = new PostVO();
	      
	      postVO.setId(id);
	      postVO.setPostTitle(postTitle);
	      postVO.setPostLiked(postLiked);
	      
	      psotDAO.update(postVO);
//	      resp.sendRedirect(req.getContextPath() + "/read?id=" + id);
	      resp.sendRedirect(req.getContextPath() + "/list");
	   }
}
