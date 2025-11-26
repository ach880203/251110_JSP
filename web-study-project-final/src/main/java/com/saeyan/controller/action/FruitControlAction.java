package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.MemberVO;
import com.saeyan.dao.MemberDAO;

public class FruitControlAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        MemberDAO mdao = MemberDAO.getInstance();
        List<MemberVO> list = mdao.selectAllMembers();   // ✅ 회원 전체 조회

        request.setAttribute("memberList", list);        // ✅ JSP로 전달
        request.getRequestDispatcher("/member/fruitControl.jsp").forward(request, response);
    }
}
