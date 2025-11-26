<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
   
<div class="wrap">
		<nav>
        	<ul>
                <li><a href="FruitServlet?command=fruit_home">홈으로</a></li>
                <li><a href="FruitServlet?command=fruit_home">공지사항</a></li>
                <li><a href="FruitServlet?command=fruit_Control">회원관리</a></li>
                <li><a href="FruitServlet?command=product_list">상품목록</a></li>           
            </ul>
        </nav>
<h1>상품 등록 페이지</h1>
			
 	<form method="post" name="frm" action="FruitServlet">
 		<input type="hidden" name="command" value="product_write">

         <table>
            <tr>
               <td width="150px">
               <c:choose>
                     <c:when test="${empty product.pictureUrl}">
                        <img src="upload/noimage.gif">
                     </c:when>
                     <c:otherwise>
                        <img src="upload/${product.pictureUrl}">
                     </c:otherwise>
               </c:choose>
               </td>
               <td>
                  <table style= "width:600px">
                     <tr>
                        <th style="width: 80px">상품명</th>
                        <td><input type="text" name="name" size="62"></td>
                     </tr>
                     <tr>
                        <th>가 격</th>
                        <td><input type="text" name="price" > 원</td>
                     </tr>
                     <tr>
                        <th>원산지</th>
                        <td><input type="text" name="origin" ></td>
                     </tr>
                     <tr>
                        <th>사 진</th>
                        <td><input type="file" name="pictureUrl"><br>
                           (주의사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
                     </tr>
                     <tr>
                        <th>설 명</th>
                        <td><textarea cols="65" rows="10" name="description"> </textarea>
                        </td>
                     </tr>
                  </table>
               </td>
            </tr>
         </table>
         <br> <input type="submit" value="등록" onclick="return productCheck()"> 
         	<input type="reset" value="다시작성"> 
         	<input type="button" value="목록" onclick="location.href='FruitServlet?command=product_list'">
      </form>
      
</div>
</body>
</html>