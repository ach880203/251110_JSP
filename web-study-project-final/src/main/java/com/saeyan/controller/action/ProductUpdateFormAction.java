package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

public class ProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/product/productUpdate.jsp";
		
		String code = request.getParameter("code");
			
		ProductDAO pDao = ProductDAO.getInstance();
			
		ProductVO pVo = pDao.slectProductByCode(code);
			
		request.setAttribute("product", pVo);
			
		request.getRequestDispatcher(url).forward(request, response);

		
	}

}
