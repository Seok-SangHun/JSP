package com.app.jdbc.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.student.dao.StudentDAO;
import com.app.jdbc.student.vo.StudentVO;


public class StudentRead extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		String input = req.getParameter("id");
		Long id = Long.valueOf(input);
		StudentVO studentVO = studentDAO.selectById(id);
		req.setAttribute("student", studentVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}
}

