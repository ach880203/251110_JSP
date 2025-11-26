<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>아이디 찾기</title>
        <link rel="stylesheet" type="text/css" href="css/shop.css">
    </head>

    <body>
        <header>
            <nav>
                <ul>
                    <li style ="border: white; font-size:50px" >
                과일농장</li>
                </ul>
            </nav>
        </header>
	<div class="login-container">
        <h2>아이디 찾기</h2>

        <form action="<%=request.getContextPath()%>/FruitServlet?command=fruit_find_id_action" method="post">
            <table class="list">
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" name="email" required></td>
                </tr>
            </table>
            <br>
            <div align="center">
            <input type="submit" value="아이디 찾기">
            <input type="button" value="취소" onclick="history.back()">
            </div>
        </form>
	</div>
        <footer>
            <p>COPYRIGHT(C) 2025 과일농장, Inc. All Rights Reserved</p>
        </footer>

    </body>

    </html>