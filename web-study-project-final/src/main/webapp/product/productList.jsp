<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
</head>
<header>
    <nav>
    <ul>
        <li><a href="FruitServlet?command=fruit_home">공지사항</a></li>
        <li><a href="FruitServlet?command=fruit_Control">회원관리</a></li>
        <li><a href="FruitServlet?command=product_list">상품관리</a></li>           
    </ul>
    <div class="logout-container">
        <a href="FruitServlet?command=fruit_logout" class="logout-btn">로그아웃</a>
    </div>
	</nav>
</header>
<body>
<h1>상품관리 페이지</h1>
   <table class="list">
      	<tr>
      		<td colspan="6" style ="border: white; text-align:left; font-size:25px ">
      		<b>상품관리</b></td>
      	</tr>
      	<tr>
            <td colspan="6" style="border: white; text-align: right">
            <a href="FruitServlet?command=product_write_form"><b>상품 등록</b></a></td>
        </tr>
      	<tr>
      		<th style = "width:10px">번호</th>	
      		<th>상품명</th>	
      		<th>가격</th>	
      		<th>원산지</th>
      		<th>수정</th>		
      		<th>삭제</th>				
     	 </tr>
     	 <c:forEach var="product" items="${productList}">
         <tr class="record">
            <td>${product.code}</td>
            <td><a href="FruitServlet?command=product_view_form&code=${product.code}">${product.name}</a></td>
            <td>${product.price} 원</td>
            <td>${product.origin}</td>
            <td><a href="FruitServlet?command=product_update_form&code=${product.code}">상품 수정</a> </td>
            <td><a href="FruitServlet?command=product_delete&code=${product.code}" onclick="return confirm('정말 삭제하시겠습니까?');">상품 삭제</a> </td>
            </tr>
         </c:forEach>
      		
      
	</table>
			

<footer><p>COPYRICHT(C) 2025 과일농장, lnc. All Rights Reserved</p></footer>
</body>
</html>