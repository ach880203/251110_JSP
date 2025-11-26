package com.saeyan.controller.action;

import javax.servlet.http.*;
import java.io.IOException;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class FruitUpdateAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");

        MemberVO mvo = new MemberVO();
        mvo.setUserId(request.getParameter("user_id"));   // ★ hidden으로 들어온 userId
        mvo.setName(request.getParameter("name"));
        mvo.setUserpw(request.getParameter("userpw"));
        mvo.setPhone(request.getParameter("phone"));
        mvo.setNick(request.getParameter("nick"));
        mvo.setEmail(request.getParameter("email"));
        mvo.setAdmin(Integer.parseInt(request.getParameter("admin")));
        mvo.setAddress(request.getParameter("address"));

        MemberDAO mdao = MemberDAO.getInstance();
        mdao.updateMember(mvo);

          // userId도 URL에 넘겨줘야 상세 페이지에서 조회 가능!
        String userId = request.getParameter("user_id");
        System.out.println("업데이트 유저아이디 = " +userId);
        

        response.setContentType("text/html; charset=UTF-8");
        java.io.PrintWriter out = response.getWriter();
        out.println( "<script>alert('수정 완료!'); location.href='FruitServlet?command=fruit_UDP&user_id="
                + userId + "';</script>");
        
    }
}
