package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.NoticeVO;
import com.saeyan.dao.NoticeDAO;

public class FruitHomeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 이동할 JSP 페이지 경로를 문자열로 지정함(게시판 목록 화면)
	      String url = "/fruit/fruitHome.jsp";  
	      
	      NoticeDAO nbao = NoticeDAO.getInstance(); 
			 
			 List<NoticeVO> list = nbao.selectAllfruits();
			 
			 request.setAttribute("fruitList", list);
	      
	      request.getRequestDispatcher(url)
	      .forward(request, response);
	}

	

}
