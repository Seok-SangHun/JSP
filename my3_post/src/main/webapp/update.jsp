<%@page import="com.app.jdbc.post.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<% PostVO postVO = (PostVO)request.getAttribute("post"); %>
   
   <form action="update/ok" method="post">
      <input type="text" name="postTitle" placeholder="제목을 작성하세요." value="<%=postVO.getPostTitle()%>">
      <input type="text" name="postLiked" value="<%=postVO.getPostLiked()%>">
      <input type="hidden" name="id" value="<%=postVO.getId() %>">
      <button>수정 완료</button>
   </form>
</body>
</html>