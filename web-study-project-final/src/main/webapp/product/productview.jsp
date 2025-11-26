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
<body>
<div class="wrap">
		<nav>
        	<ul>
                <li><a href="FruitServlet?command=fruit_home">공지사항</a></li>
                <li><a href="FruitServlet?command=fruit_Control">회원관리</a></li>
                <li><a href="FruitServlet?command=product_list">상품관리</a></li>           
            </ul>
        </nav>
<h1>상품 상세 페이지</h1>
			
 	<form method="post" name="frm" action="FruitServlet">
 		<input type="hidden" name="command" value="product_update_form">
         <input type="hidden" name="code" value="${product.code}"> 
		          
         <table>
            <tr>
               <td width="150px"><c:choose>
                     <c:when test="${empty product.pictureUrl}">
                        <img src="upload/noimage.gif" style="width:100%; height:auto;">
                     </c:when>
                     <c:otherwise>
                        <img src="upload/${product.pictureUrl}" style="width:100%; height:auto;">
                     </c:otherwise>
                  </c:choose></td>
               <td>
                  <table style= "width:600px">
                     <tr>
                        <th style="width: 80px">상품명</th>
                        <td>${product.name}</td>
                     </tr>
                     <tr>
                        <th>가 격</th>
                        <td>${product.price} 원</td>
                     </tr>
                     <tr>
                        <th>원산지</th>
                        <td>${product.origin}</td>
                     </tr>
                
                     <tr>
                        <th>설 명</th>
                        <td>${product.description}</td>
                     </tr>
                  </table>
               </td>
            </tr>
         </table>
         <div align="center">
         <input type="hidden" name="nonmakeImg" value="${product.pictureUrl}">
         <br> <input type="submit" value="수정하기" onclick="return productCheck()"> 
         	<input type="button" value="삭제하기" onclick="
           if (confirm('정말 삭제하시겠습니까?')) {
               location.href='FruitServlet?command=product_delete&code=${product.code}';
           }
       		">
         	<input type="button" value="목록" onclick="location.href='FruitServlet?command=product_list'">
     	 </div>
      </form>
      
</div>
</body>
</html>