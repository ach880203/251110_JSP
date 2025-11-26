package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;
import java.nio.file.Paths;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

public class ProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 값 가져오기
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String origin = request.getParameter("origin");
		String description = request.getParameter("description");
		
		
	    // 2. 파일 업로드 처리
	    Part filePart = request.getPart("pictureUrl"); // input name="pictureUrl"
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // 파일명 추출

	    // 서버에 저장할 경로 설정 (WebContent/upload)
	    String uploadPath = request.getServletContext().getRealPath("/upload");
	    java.io.File uploadDir = new java.io.File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdirs();

	    if (fileName != null && !fileName.isEmpty()) {
	        filePart.write(uploadPath + java.io.File.separator + fileName);
	    }

	    // pictureUrl DB에 저장
	    String pictureUrl = fileName != null && !fileName.isEmpty() ? fileName : null;
		
				
		ProductVO pVo = new ProductVO();
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setOrigin(origin);
		pVo.setDescription(description);
		pVo.setPictureUrl(pictureUrl);
				
		//2. DAO 통해 DB저장
		ProductDAO pDao = ProductDAO.getInstance();
				
		pDao.insertProduct(pVo);
				
		//3. 화면 전환
		// Post -> Redirect -> Get (PRG방식)
		response.sendRedirect("FruitServlet?command=product_list");
//		new BoardListAction().execute(request, response);
				
		
	}

}
