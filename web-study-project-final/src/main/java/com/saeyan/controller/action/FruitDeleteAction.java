package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.NoticeDAO;

public class FruitDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		ndao.deletefruit(num);
		
		response.sendRedirect("FruitServlet?command=fruit_home");
		
	}

}
