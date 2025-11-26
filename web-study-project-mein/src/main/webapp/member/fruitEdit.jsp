<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>회원 정보 수정</h2>

<form action="<%=request.getContextPath()%>/FruitServlet?command=fruit_update" method="post">
    
    <!-- 필수 파라미터들 -->
   <input type="hidden" name="user_id" value="${mvo.userId}">


<table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>회원번호</th>
        <td><input type="text" value="${mvo.memberId}" readonly></td>
    </tr>
    <tr>
        <th>아이디</th>
        <td><input type="text" value="${mvo.userId}" readonly></td>
    </tr>
    <tr>
        <th>이름</th>
        <td><input type="text" name="name" value="${mvo.name}" readonly></td>
    </tr>
    <tr>
        <th>비밀번호</th>
        <td><input type="password" name="userpw" value="${mvo.userpw}"></td>
    </tr>
    <tr>
        <th>닉네임</th>
        <td><input type="text" name="nick" value="${mvo.nick}"></td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td><input type="text" name="phone" value="${mvo.phone}"></td>
    </tr>
    <tr>
        <th>이메일</th>
        <td><input type="text" name="email" value="${mvo.email}"></td>
    </tr>
    <tr>
        <th>권한</th>
        <td>
            <select name="admin">
                <option value="0" ${mvo.admin == 0 ? "selected" : ""}>일반회원</option>
                <option value="1" ${mvo.admin == 1 ? "selected" : ""}>관리자</option>
            </select>
        </td>
    </tr>
    <tr>
        <th>주소</th>
        <td><input type="text" name="address" value="${mvo.address}"></td>
    </tr>
</table>

<br>
<input type="submit" value="수정하기">
<input type="button" value="취소" onclick="history.back();">

</form>
