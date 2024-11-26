<%@page import="com.app.mvc.domain.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
   <% 
   ProductVO productVO = (ProductVO) request.getAttribute("product");
   %>
   <form action="update/ok.product" method="post">
      <input type="text" name="productName" placeholder="상품명을 작성하세요." value="<%=productVO.getProductName()%>">
      <input type="number" name="productPrice" placeholder="상품 가격" value="<%=productVO.getProductPrice()%>">
      <input type="hidden" name="id" value="<%=productVO.getId() %>">
      <button type="submit">수정 완료</button>
   </form>
</body>
</html>
