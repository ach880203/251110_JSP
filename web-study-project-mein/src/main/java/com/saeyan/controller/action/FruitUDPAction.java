package com.saeyan.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class FruitUDPAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("user_id");
        System.out.println("FruitUDPAction user_id = " + userId);
        MemberDAO mdao = MemberDAO.getInstance();
        MemberVO mvo = mdao.getMember(userId);   // ← DB에서 회원 정보 받아오기

        request.setAttribute("mvo", mvo);        // ← JSP로 보내기

        request.getRequestDispatcher("/member/fruitUDP.jsp")
               .forward(request, response);
    }
}
