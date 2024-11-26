package com.app.jdbc.menu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.menu.dao.MenuDAO;
import com.app.jdbc.menu.vo.MenuVO;


public class MenuRead extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDAO menuDAO = new MenuDAO();
		String input = req.getParameter("id");
		Long id = Long.valueOf(input);
		MenuVO menuVO = menuDAO.selectById(id);
		req.setAttribute("menu", menuVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}
}
