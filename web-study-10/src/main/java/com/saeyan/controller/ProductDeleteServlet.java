package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDeleteServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1,(코드 값 왹득)

		String code = request.getParameter("code");

		// 2. 데이터베이스에서 코드 해당값 삭제
		ProductDAO pdao = ProductDAO.getInstance();
		ProductVO vo = pdao.selectProductByCode(code);

		// 3. request.setatturibute 저장.
		request.setAttribute("product", vo);

		// 4.삭제 화면으로 포워드
		request.getRequestDispatcher("product/productDelete.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 기본 코드값 획득
		int code = Integer.parseInt(request.getParameter("code"));
		
		// 2. 데이터베이스에서 코드값 삭제
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.deleteProduct(code);
		
		// 3. 리다이렉트 프로덕트 리스트로
		response.sendRedirect("ProductList.do");
	}
}
