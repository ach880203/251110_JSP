<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원 상세 페이지</title>

<link rel="stylesheet" type="text/css" href="css/shop.css">

</head>

<body>

   <header>
      <nav>
         <ul>
            <li><a
               href="<%=request.getContextPath()%>/FruitServlet?command=fruit_home">공지사항</a></li>
            <li><a
               href="<%=request.getContextPath()%>/FruitServlet?command=fruit_Control">회원관리</a></li>
            <li><a
               href="<%=request.getContextPath()%>/FruitServlet?command=product_list">상품목록</a></li>
         </ul>
      </nav>
   </header>

   <h2>회원 상세 페이지</h2>

   <form
      action="<%=request.getContextPath()%>/FruitServlet?command=fruit_update"
      method="post">


      <table class="list">

         <tr>
            <th>번호</th>
            <td>${mvo.memberId}</td>
         </tr>
         <tr>
            <th>이름</th>
            <td>${mvo.name}</td>
         </tr>
         <tr>
            <th>아이디</th>
            <td>${mvo.userId}</td>
         </tr>

         <tr>
            <th>암 호</th>
            <td><span> 비밀번호 보안처리됨 </span></td>
         </tr>

         <tr>
            <th>닉네임</th>
            <td>${mvo.nick}</td>
         </tr>

         <tr>
            <th>전화번호</th>
            <td>${mvo.phone}</td>
         </tr>
         <tr>
            <th>email</th>
            <td>${mvo.email}</td>
         </tr>
         <tr>
            <th>회원가입일</th>
            <td>${mvo.regDate}</td>
         </tr>
         <tr>
            <th>주소</th>
            <td>${mvo.address}</td>
         </tr>
         <tr>
            <th>권한</th>
            <td>${mvo.admin}</td>
         </tr>
      </table>

      <br> 
      <div align="center">
      <input type="button" value="수정"
         onclick="location.href='FruitServlet?command=fruit_edit_form&user_id=${mvo.userId}'">

      <input type="button" value="취소"
       onclick="location.href='FruitServlet?command=fruit_Control'">
       
      <input type="button" value="회원 삭제" onclick="
           if (confirm('정말 삭제하시겠습니까?')) {
               location.href='FruitServlet?command=fruit_UDP_delete&user_id=${mvo.userId}';
           }
       		">
       		
		</div>
   </form>

   <footer>
      <p>COPYRICHT(C) 2025 과일농장, Inc. All Rights Reserved</p>
   </footer>

</body>

</html>