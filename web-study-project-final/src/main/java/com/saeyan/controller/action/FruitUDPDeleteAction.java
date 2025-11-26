package com.saeyan.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.saeyan.dao.MemberDAO;

public class FruitUDPDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("user_id");

        MemberDAO mdao = MemberDAO.getInstance();
        mdao.deletemember(userId);

        response.setContentType("text/html; charset=UTF-8");
        java.io.PrintWriter out = response.getWriter();

        out.println("<script>");
        out.println("alert('회원이 삭제되었습니다.');");
        out.println("location.href='FruitServlet?command=fruit_Control';");
        out.println("</script>");

        out.flush();
        return;  }
}
