package com.app.jdbc.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.student.dao.StudentDAO;


public class StudentUpdate extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		Long id =Long.valueOf(req.getParameter("id"));
		req.setAttribute("student", studentDAO.selectById(id));
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}
