package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.NoticeVO;
import com.saeyan.dao.NoticeDAO;

public class FruitNDPwriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * num int primary key auto_increment,
			pass varchar(30) not null, 
			title varchar(30) , 
			date varchar (30),
			views int default 0,
			text TEXT (50)
		 */
		
		String title = request.getParameter("title");
		String pass = request.getParameter("pass");
		String date = request.getParameter("date");
		String views = request.getParameter("views");
		String text = request.getParameter("text");
		
		NoticeVO vo = new NoticeVO();
		
		vo.setTitle(title);
		vo.setPass(pass);
		vo.setDate(date);
		vo.setViews(views);
		vo.setText(text);
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		ndao.insertFruit(vo);
		
		response.sendRedirect("FruitServlet?command=fruit_home");
	}

}
