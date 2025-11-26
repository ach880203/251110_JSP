package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class FruitEditFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_id = request.getParameter("user_id");

		
		MemberDAO mdao = MemberDAO.getInstance();
		MemberVO mvo = mdao.getMemberByUserId(user_id);
		
		request.setAttribute("mvo", mvo);
		request.getRequestDispatcher("member/fruitEdit.jsp")
		.forward(request, response);
		
	}

}
