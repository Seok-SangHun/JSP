package com.app.jdbc.menu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.menu.dao.MenuDAO;
import com.app.jdbc.menu.vo.MenuVO;


public class MenuList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDAO menuDAO = new MenuDAO();
		List<MenuVO> menus = menuDAO.selectAll();
		
		req.setAttribute("menus", menus);
		req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}

}