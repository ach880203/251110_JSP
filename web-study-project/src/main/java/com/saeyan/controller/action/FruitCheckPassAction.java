package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.NoticeVO;
import com.saeyan.dao.NoticeDAO;

public class FruitCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO vo = ndao.selectOneByNum(Integer.parseInt(num));
		
		if(pass.equals(vo.getPass())) {
			url = "/fruit/fruitCheckSuccess.jsp";
		}else {
			url = "/fruit/fruitCheckPass.jsp";
			request.setAttribute("massage", "비밀번호가 틀렸습니다");
		}
		
		request.getRequestDispatcher(url)
		.forward(request, response);
	}

}
