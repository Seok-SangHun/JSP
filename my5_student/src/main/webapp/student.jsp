<%@page import="com.app.jdbc.student.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
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
	<% List<StudentVO> students = (List<StudentVO>)request.getAttribute("students"); %>
	<button id="go-write">등록하기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>점수</th>
		</tr>
		<%for(StudentVO studentVO: students) {%>
			<tr>
				<td><%=studentVO.getId()%></td>
				<td><a href="read?id=<%=studentVO.getId() %>"><%=studentVO.getStudentName()%></a></td>
				<td><%=studentVO.getStudentScore()%></td>
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