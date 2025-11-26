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
         <input type="hidden" name="command" value="fruit_NDPupdate">
         <input type="hidden" name="num" value="${fruit.num }">
	<table>
            <tr>
               <th width="50">제목</th>
               <td><input type="text" size="70" name="title" value="${fruit.title }"></td>
            </tr>
            <tr>
               <th>암호</th>
               <td><input type="password" size="20" name="pass"></td>
            </tr>
            <tr>
               <th>작성일</th>
               <td> <input name="date"value="${fruit.date }" ></td>
            </tr>
            <tr>
               <th>내용</th>
               <td>
               <textarea cols="70" rows="15" name="text">${fruit.text }</textarea></td>
            </tr>
         </table>
	<br>
	<div align="center">
	<input type="submit" value="완료" 
		onclick="return fruit()">
	<input type="reset" value="다시 작성">
	<input type="button" value="목록으로" onclick="location.href='FruitServlet?command=fruit_home'">
	</div>
	</form>
</body>
</html>