package com.app.jdbc.product.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.product.dao.ProductDAO;

public class ProductUpdate extends HttpServlet{
	   private static final long serialVersionUID = 1L;
	   
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   ProductDAO productDAO = new ProductDAO();
		   Long id = Long.valueOf(req.getParameter("id"));
		   req.setAttribute("product", productDAO.selectById(id));
		   req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}
