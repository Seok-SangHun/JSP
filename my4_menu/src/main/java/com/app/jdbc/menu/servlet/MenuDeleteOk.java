package com.app.jdbc.menu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.menu.dao.MenuDAO;

public class MenuDeleteOk extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		MenuDAO menuDAO = new MenuDAO();
		
		menuDAO.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
