package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public productUpdateServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//1.코드값 가지고 오기.
		String code = request.getParameter("code");
		
	// 2. ProductDAO 통해서 code값 전체 가지고 오기
		ProductDAO pdao = ProductDAO.getInstance();
		 
		ProductVO vo = pdao.selectProductByCode(code);
		
	//3. request,setAtribute wjwkd
		request.setAttribute("product", vo);
		
    //4. forword
		request.getRequestDispatcher("product/productUpdate.jsp")
		.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
