<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
</head>
<body>
	<div align="center">
      <h1>공지글 등록</h1>
      <form name="frm" method="post" action="FruitServlet">
         <input type="hidden" name="command" value="fruit_write">
         <table>
            <tr>
               <th width="50">제목</th>
               <td><input type="text" size="70" name="title"></td>
            </tr>
            <tr>
               <th>암호</th>
               <td><input type="password" size="20" name="pass"></td>
            </tr>
            <tr>
               <th>작성일</th>
               <td><input type="text" name="date"> </td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="text"></textarea></td>
            </tr>
         </table>
         <br>
         <br> 
         <div align="center">
         <input type="submit" value="등록" onclick="return fruitCheck()"> 
         	  <input type="reset"value="다시 작성"> 
         	  <input type="button" value="목록" onclick="location.href='FruitServlet?command=fruit_home'">
		</div>     
      </form>
</body>
</html>