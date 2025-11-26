package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class FruitLoginProcessAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      
      String userId = request.getParameter("userId");
      String userPw = request.getParameter("userPw");
      
      MemberDAO dao = MemberDAO.getInstance();
      MemberVO member = dao.userCheck(userId, userPw);
      
      if (member != null) {
         HttpSession session = request.getSession();
         session.setAttribute("loginUser", member);
         session.setAttribute("userId", member.getUserId());
         session.setAttribute("userName", member.getName());
         
         response.sendRedirect("FruitServlet?command=fruit_home");
      } else {
         request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
         request.getRequestDispatcher("/home/fruitLogin.jsp").forward(request, response);
      }
   }
}
