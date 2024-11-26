<%@page import="com.app.jdbc.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<% UserVO userVO = (UserVO)request.getAttribute("user"); %>
   
   <form action="update/ok" method="post">
      <input type="text" name="userName" placeholder="이름을 작성하세요." value="<%=userVO.getUserName()%>">
      <input type="text" name="userAge" value="<%=userVO.getUserAge()%>">
      <input type="hidden" name="id" value="<%=userVO.getId() %>">
      <button>수정 완료</button>
   </form>
</body>
</html>