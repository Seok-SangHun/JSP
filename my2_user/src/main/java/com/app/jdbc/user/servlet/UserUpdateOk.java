package com.app.jdbc.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;
import com.app.jdbc.user.vo.UserVO;


public class UserUpdateOk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	   
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("UTF-8");
	      Long id = Long.valueOf(req.getParameter("id"));
	      String userName = req.getParameter("userName");
	      int userAge = Integer.parseInt(req.getParameter("userAge"));
	      
	      UserDAO userDAO = new UserDAO();
	      UserVO userVO = new UserVO();
	      
	      userVO.setId(id);
	      userVO.setUserName(userName);
	      userVO.setUserAge(userAge);
	      
	      userDAO.update(userVO);
//	      resp.sendRedirect(req.getContextPath() + "/read?id=" + id);
	      resp.sendRedirect(req.getContextPath() + "/list");
	   }
}
