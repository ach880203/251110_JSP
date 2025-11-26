<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shop.css">
</head>
<body>
	<h1>비밀번호 확인</h1>
	<form name="frm" method="get" action="FruitServlet">
    <input type="hidden" name="command" value="fruit_check_pass">
    <input type="hidden" name="num" value="${param.num}">    
    <table>
    	<tr>
    		<th>비밀번호</th>
    		<td><input type="password" name="pass" size="20"></td>
    	</tr>
			</table>
			<br>
			<input type="submit" value="확인" onclick="return passCheck()">
			<br><br>${message}
    </table>
    </form>
</body>
</html>