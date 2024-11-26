<%@page import="com.app.jdbc.student.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<% StudentVO studentVO = (StudentVO)request.getAttribute("student"); %>
   
   <form action="update/ok" method="post">
      <input type="text" name="studentName" placeholder="이름을 작성하세요." value="<%=studentVO.getStudentName()%>">
      <input type="text" name="studentScore" value="<%=studentVO.getStudentScore()%>">
      <input type="hidden" name="id" value="<%=studentVO.getId() %>">
      <button>수정 완료</button>
   </form>
</body>
</html>