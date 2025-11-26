<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" charset="UTF-8">
        <title>회원가입</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
       <script type="text/javascript" src="script/join.js"></script>
    </head>

   <header>
        <nav>
           <ul>
                <li style ="border: white; font-size:50px" >
                과일농장</li>           
            </ul>
        </nav> 
   </header>
   
    <body>
        <div class="login-container">
            <h2>회원가입</h2>
            '* '표시는 필수 입력 항목입니다.

            <form name="joinForm" action="<%=request.getContextPath()%>/FruitServlet?command=fruit_join_action"
                method="post" onsubmit="return joinCheck()">
                <!-- 아이디 중복확인 여부를 저장하는 hidden 필드 -->
                <input type="hidden" name="idChecked" value="false">
                <!-- 관리자 권한 필드 (0: 일반회원, 1: 관리자) -->
                <input type="hidden" name="admin" value="0">

                <div class="input-group">
                    <table>

                        <tr>
                            <td>이름(*)</td>
                            <td><input type="text" name="name" size="20"></td>
                        </tr>

                        <tr>
                            <td>아이디(*)</td>
                            <td>
                                <input type="text" name="userId" size="20">
                                <input type="button" value="중복확인" onclick="openIdCheck()"
                                    style="padding: 5px 10px; cursor: pointer; background-color: #4CAF50; color: white; border: none; border-radius: 3px;">
                            </td>
                        </tr>

                        <tr>
                            <td>비밀번호(*)</td>
                            <td><input type="password" name="userpw" size="20"></td>
                        </tr>

                        <tr>
                            <td style="white-space: nowrap;">비밀번호확인(*)</td>
                            <td><input type="password" name="userpw_check" size="20"></td>
                        </tr>

                        <tr>
                            <td>닉네임(*)</td>
                            <td><input type="text" name="nick" size="20" placeholder="2-10자"></td>
                        </tr>

                        <tr>
                            <td>전화번호(*)</td>
                            <td><input type="text" name="phone" size="20" placeholder="01012345678"></td>
                        </tr>

                        <tr>
                            <td>email(*)</td>
                            <td><input type="text" name="email" size="20" placeholder="example@email.com"></td>
                        </tr>

                        <tr>
                            <td>주소(*)</td>
                            <td><input type="text" name="address" size="30"></td>
                        </tr>

                    </table>

                    <div class="links">
                        <input type="submit" value="확인" >
                        <input type="reset" value="취소"onclick="location.href='FruitServlet?command=fruit_login' ">
                    </div>
                </div>
            </form>
        </div>
    </body>
    
        <footer>
            <p>COPYRICHT(C) 2025 과일농장, lnc. All Rights Reserved</p>
        </footer>
        
        

    </html>
    
    
   