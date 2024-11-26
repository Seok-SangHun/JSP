package com.app.task.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Task
 */
@WebServlet("/Task")
public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ageParam = request.getParameter("age");

	    // String에서 int로 변환
	    int age = Integer.parseInt(ageParam) - 1;
	      
//	      forward
//	      1. request 영역에 데이터를 담고 화면에서 꺼내쓸 수 있다.
//	      2. 응답페이지가 나타났을 때, 요청했던 경로가 브라우저에 나타난다.
	      
//	      request.getRequestDispatcher("name.jsp").forward(request, response);
	      
//	      redirect
//	      1. request 영역이 초기화되기 때문에 화면에서 꺼내쓰면 null이다.
//	      2. 응답페이지가 나타났을 때, 마지막 응답 경로가 브라우저에 나타난다.
//	      3. redirect로 데이터를 전달해야 할 때에는 쿼리스트링을 작성해야 한다.
	      
//	      ※ 쿼리스트링
//	      쿼리스트링은 URL 뒤에 물음표(?)로 시작하며, key=value 형태로 이어진다.
//	      여러 개의 데이터를 전달할 때에는 ?key=value&key=value와 같이 &문자를 작성한다.
	      
//	      response.sendRedirect("name.jsp");
//	      response.sendRedirect(request.getContextPath() + "/name");
	      
	 // adjustedAge를 URL 파라미터로 인코딩하여 리다이렉트
	    response.sendRedirect(request.getContextPath() + "/age?age=" + age);
	      
//	      System.out.println(request.getRequestURI());
//	      response.setCharacterEncoding("UTF-8");
//	      PrintWriter out = response.getWriter();
//	      response.setContentType("text/html; charset=UTF-8");
//	      out.write("<h1>안녕!</h1>");
//	      out.close();
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
