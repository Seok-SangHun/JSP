package com.app.jdbc.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;
import com.app.jdbc.user.vo.UserVO;

public class UserWriteOk extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("userName");
		int userAge = Integer.parseInt(req.getParameter("userAge"));
		UserVO userVO = new UserVO();
		UserDAO UserDAO = new UserDAO();
		
		userVO.setUserName(userName);
		userVO.setUserAge(userAge);
		
		UserDAO.insert(userVO);
		
		resp.sendRedirect(req.getContextPath()+"/list");
	}
}
