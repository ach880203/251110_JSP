package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 이동할 JSP 페이지 경로를 문자열로 지정함(게시판 목록 화면)
	    String url = "/product/productWrite.jsp";  

	    // 지정한 JSP 페이지로 request와 response를 전달하여 화면을 이동함(서버 내부 이동, URL 변화 없음)
 		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
