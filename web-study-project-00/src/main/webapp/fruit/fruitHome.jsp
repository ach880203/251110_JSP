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
</head>
<body>
	
	 <header>
        <nav>
        	<ul>
                <li><a href="FruitServlet?command=fruit_home">홈으로</a></li>
                <li><a href="FruitServlet?command=fruit_home">공지사항</a></li>
                <li><a href="FruitServlet?command=fruit_Control">회원관리</a></li>
                <li><a href="FruitServlet?command=product_list">상품목록</a></li>           
            </ul>
        </nav> 
        <h1>과일 농장에 오신 것을 환영합니다!</h1><br>    	
      <table>
      	<tr>
      		<td colspan="5" style="border: white; text-align: left;"><a
               href="FruitServlet?command=fruit_NDP_form"><b>공지 등록</b></a></td>
      	</tr>
      	<tr style="font-size: 20px; text-align: center;">
      		<td colspan="5" style ="border: white; text-align:left; font-size:25px ">
      		<b>공지사항</b></td>
      	</tr>
      	<tr>
      		<th>번호</th>	
      		<th>제목</th>	
      		<th>작성일</th>	
      		<th>조회수</th>	
      		<th>내용</th>	
      </tr>
      <c:forEach var="fruit" items="${fruitList }">
            <tr class="record">
               <td>${fruit.num }</td>
               <td><a href="FruitServlet?command=fruit_NDP&num=${fruit.num}">${fruit.title }</a></td>
               <td>${fruit.date }</td>
               <td>${fruit.views}</td>
            </tr>
         </c:forEach>
      </table>	
   </header>
     <footer><p>COPYRICHT(C) 2025 과일농장, lnc. All Rights Reserved</p></footer>
</body>
</html>