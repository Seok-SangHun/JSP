package com.app.my.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyIntro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyIntro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		String operation = request.getParameter("operation");

		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(num2Str);
		int result = 0;

		switch(operation) {
			case "add":
				result = num1 + num2;
				break;
			case "subtract":
				result = num1 - num2;
				break;
			case "multiply":
				result = num1 * num2;
				break;
			case "divide":
				result = num1 / num2;
				break;
		}

		request.setAttribute("result", result);
		request.getRequestDispatcher("num.jsp").forward(request, response);
	}


}
