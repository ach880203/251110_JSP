<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
		<nav>
        	<ul>
                <li><a href="FruitServlet?command=fruit_home">공지사항</a></li>
                <li><a href="FruitServlet?command=fruit_Control">회원관리</a></li>
                <li><a href="FruitServlet?command=product_list">상품관리</a></li>    
            </ul>
        </nav>
	<h1>공지 상세 페이지</h1>
	<form name="frm" method="post" action="FruitServlet">
         <input type="hidden" name="command" value="fruit_write">
	<table>
		<tr>
			<th width="50">번호</th>
			<td>${fruit.num }</td>
		</tr>
		<tr>	
			<th>제목</th>
			<td>${fruit.title }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${fruit.date }</td>
		</tr>
		<tr>	
			<th>조회수</th>
			<td>${fruit.views}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td colspan="3"><pre>${fruit.text}</pre></td>
		</tr>
	</table>
	<br>
	<div align="center">
	<input type="button" value="수정" 
		onclick="location.href='FruitServlet?command=fruit_NDPupdate_form&num=${fruit.num}'">
	<input type="button" value="삭제" 
		onclick="open_win('FruitServlet?command=fruit_check_pass_form&num=${fruit.num}','delete')">
	<input type="button" value="목록으로" onclick="location.href='FruitServlet?command=fruit_home'">
	</div>
	</form>
</body>
</html>