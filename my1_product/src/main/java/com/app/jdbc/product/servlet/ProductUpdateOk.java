package com.app.jdbc.product.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.product.dao.ProductDAO;
import com.app.jdbc.product.vo.ProductVO;


public class ProductUpdateOk extends HttpServlet{
	   private static final long serialVersionUID = 1L;
	   
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("UTF-8");
	      Long id = Long.valueOf(req.getParameter("id"));
	      String productName = req.getParameter("productName");
	      int productPrice = Integer.parseInt(req.getParameter("productPrice"));
	      
	      ProductDAO productDAO = new ProductDAO();
	      ProductVO productVO = new ProductVO();
	      
	      productVO.setId(id);
	      productVO.setProductName(productName);
	      productVO.setProductPrice(productPrice);
	      
	      productDAO.update(productVO);
//	      resp.sendRedirect(req.getContextPath() + "/read?id=" + id);
	      resp.sendRedirect(req.getContextPath() + "/list");
	   }

}
