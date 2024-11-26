package com.app.jdbc.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.student.dao.StudentDAO;
import com.app.jdbc.student.vo.StudentVO;


public class StudentList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		List<StudentVO> students = studentDAO.selectAll();
		
		req.setAttribute("students", students);
		req.getRequestDispatcher("student.jsp").forward(req, resp);
	}

}