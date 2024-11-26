<%@page import="com.app.jdbc.post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<style>
	table {
		width: 700px;
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		border: 1px solid black;
	}
	
	td, th {
		border: 1px solid black;
	}
</style>
</head>
<body>
	<% List<PostVO> posts = (List<PostVO>)request.getAttribute("posts"); %>
	<button id="go-write">등록하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>좋아요 수</th>
		</tr>
		<%for(PostVO postVO: posts) {%>
			<tr>
				<td><%=postVO.getId()%></td>
				<td><a href="read?id=<%=postVO.getId() %>"><%=postVO.getPostTitle()%></a></td>
				<td><%=postVO.getPostLiked()%></td>
			</tr>
		<%} %>
	</table>
</body>
<script>
	const goWriteButton = document.getElementById("go-write");
	goWriteButton.addEventListener("click", (e) => {
		// 이동
		location.href = "write";
	});
</script>
</html>