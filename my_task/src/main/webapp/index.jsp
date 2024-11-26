<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>계산기</h1>
	<form action="num" method="get" id="myForm">
		<input type="text" name="num1" placeholder="첫 번째 숫자"><br>
		<input type="text" name="num2" placeholder="두 번째 숫자"><br>
		<select name="operation">
			<option value="add">더하기</option>
			<option value="subtract">빼기</option>
			<option value="multiply">곱하기</option>
			<option value="divide">나누기</option>
		</select><br>
		<input type="submit" value="계산">
	</form>
</body>
<script>
	document.getElementById("btn").addEventListener("click", function() {
		document.getElementById("myForm").submit();
	});
</script>
</html>