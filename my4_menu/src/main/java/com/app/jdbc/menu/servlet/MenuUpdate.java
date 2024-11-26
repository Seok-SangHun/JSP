package com.app.jdbc.menu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.menu.dao.MenuDAO;


public class MenuUpdate extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDAO menuDAO = new MenuDAO();
		Long id =Long.valueOf(req.getParameter("id"));
		req.setAttribute("menu", menuDAO.selectById(id));
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}