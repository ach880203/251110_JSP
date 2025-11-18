package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
		System.out.println(vo);
    //4. forword
		request.getRequestDispatcher("product/productUpdate.jsp")
		.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 
			request.setCharacterEncoding("utf-8");
			
			ServletContext context = getServletContext();
			System.out.println("context : " + context);
			
			String path = context.getRealPath("upload");
			System.out.println("path : " + path);
			
			String encType = "utf-8";
			
			int sizeLimit = 20*1024*1024;//파일용량 크기 20MB 제한
		
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, 
					            encType,  new DefaultFileRenamePolicy());
			
		int code = Integer.parseInt(multi.getParameter("code"));
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		
		String pictureUrl = multi.getFilesystemName("pictureUrl");

		if (pictureUrl == null) {
		    pictureUrl = multi.getParameter("nonmakeImg");    
		}
		

		
		ProductVO vo = new ProductVO();
		vo.setCode(code);
		vo.setName(name);
		vo.setPrice(price);
		vo.setDescription(description);
		vo.setPictureUrl(pictureUrl);
		
		ProductDAO pdao = ProductDAO.getInstance();
		
		pdao.updateProduct(vo);
		
		response.sendRedirect("ProductList.do");
		
		
		
		}


}
