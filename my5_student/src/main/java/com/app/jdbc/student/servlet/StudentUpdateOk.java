package com.app.jdbc.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.student.dao.StudentDAO;
import com.app.jdbc.student.vo.StudentVO;


public class StudentUpdateOk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	   
	   @Override
	   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.setCharacterEncoding("UTF-8");
	      Long id = Long.valueOf(req.getParameter("id"));
	      String studentName = req.getParameter("studentName");
	      int studentScore = Integer.parseInt(req.getParameter("studentScore"));
	      

	      StudentDAO studentDAO = new StudentDAO();
	      StudentVO studentVO = new StudentVO();
	      
	      studentVO.setId(id);
	      studentVO.setStudentName(studentName);
	      studentVO.setStudentScore(studentScore);
	      
	      studentDAO.update(studentVO);
//	      resp.sendRedirect(req.getContextPath() + "/read?id=" + id);
	      resp.sendRedirect(req.getContextPath() + "/list");
	   }
}