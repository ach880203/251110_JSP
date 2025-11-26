package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.NoticeVO;
import com.saeyan.dao.NoticeDAO;

public class FruitNDPAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		NoticeVO vo = ndao.selectOneByNum(num);
		
		ndao.updateReadCount(num);
		
		request.setAttribute("fruit", vo);
		
		String url = "/fruit/fruitNDP.jsp";  
	      
	      request.getRequestDispatcher(url)
	      .forward(request, response);
		
	}

}
