<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!//선언문
	Connection conn = null;
	//Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "test";
	String pass = "1234";
	String sql = "select * from member";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 목록</h1>

	<table widht=;800 ' border='1'>
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>암호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>권한(1:관리자, 0:일반회원)</th>
		</tr>

		<%  
		
		    try{
		    	
		    	//1. oracle JDBC드라이버 클래스를 메모리에 로드
		    	//드라이브를 로드해야 DriverMnager가 오라클 DB와 통신이 가능
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 로드
			  //2.지정된 ERL, 사용자명(uid), 비밀번호(pass)로 DB 연결 생성
			  //연결 성공시 Connection 객체 반환
			conn = DriverManager.getConnection(url, uid, pass); //오라클 연결
			
			  //3. SQL 문을 데이터베이스로 전달 할  Statement 객체 생성
			  //Stetement를 통해 쿼리를 실행 할 수 있음
//			pstmt = conn.createStatement(); 수정전
			pstmt = conn.prepareStatement(sql); //sql 문장 오라클 전송
			
			//4.SQL 쿼리를 실행하고 결과(RrsultSet)를 받아옴
			//select 일 떄 결과 행들이 rs(resultSet) 객체에 저장
			//rs = stmt.executeQuery(sql); 수정전
			rs = pstmt.executeQuery(sql); //sql 구문 실행
			
			while(rs.next()){
				out.println("<tr>");
				
				out.println("<td>" +rs.getString("name") + "</td>");
				out.println("<td>" +rs.getString("userid") + "</td>");
				out.println("<td>" +rs.getString("pwd") + "</td>");
				out.println("<td>" +rs.getString("email") + "</td>");
				out.println("<td>" +rs.getString("phone") + "</td>");
				out.println("<td>" +rs.getInt("admin") + "</td>");
				
				out.println("</tr>");
			}
		    }catch(Exception e){
		    	e.printStackTrace();
		    	
		    }finally{
		    	rs.close();
		    	//stmt.close();수정전
		    	pstmt.close();
		    	conn.close();
		    }
		    
			%>


	</table>

</body>
</html>