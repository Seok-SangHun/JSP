package com.app.jdbc.product.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.product.dao.ProductDAO;


public class ProductDeleteOk extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}
}
