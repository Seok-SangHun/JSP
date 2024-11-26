package com.app.jdbc.menu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.menu.dao.MenuDAO;
import com.app.jdbc.menu.vo.MenuVO;


public class MenuUpdateOk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	   
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("UTF-8");
	      Long id = Long.valueOf(req.getParameter("id"));
	      String menuName = req.getParameter("menuName");
	      int menuPrice = Integer.parseInt(req.getParameter("menuPrice"));
	      
	      MenuDAO menuDAO = new MenuDAO();
	      MenuVO menuVO = new MenuVO();
	      
	      menuVO.setId(id);
	      menuVO.setMenuName(menuName);
	      menuVO.setMenuPrice(menuPrice);
	      
	      menuDAO.update(menuVO);
//	      resp.sendRedirect(req.getContextPath() + "/read?id=" + id);
	      resp.sendRedirect(req.getContextPath() + "/list");
	   }
}
