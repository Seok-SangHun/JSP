package com.app.jdbc.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.student.dao.StudentDAO;


public class StudentDeleteOk extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();
		
		studentDAO.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
