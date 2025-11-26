package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.NoticeDAO;
import com.saeyan.dto.NoticeVO;

public class FruitNDPUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/fruit/fruitUpdate.jsp";
		
		int num = 
				Integer.parseInt(request.getParameter("num"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		
//		ndao.updateReadCount(num);
		
		NoticeVO vo = ndao.selectOneByNum(num);
		
		request.setAttribute("fruit", vo);
		
		request.getRequestDispatcher(url)
		.forward(request, response);
	}

}
