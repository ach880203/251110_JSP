package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.NoticeDAO;
import com.saeyan.dto.NoticeVO;

public class FruitNDPUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num =Integer.parseInt(request.getParameter("num"));
		
		/*
		 * private int num;	
	private String pass;
	private String title;
	private String date;
	private String	views;
	private String text;
		 */
		
		String pass = request.getParameter("pass");
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String text = request.getParameter("text");
		
		NoticeVO vo = new NoticeVO();
		vo.setNum(num);
		vo.setPass(pass);
		vo.setTitle(title);
		vo.setDate(date);
//		vo.setViews(text);
		vo.setText(text);
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		ndao.updatefruit(vo);
		new FruitHomeAction().execute(request, response);
	}

}
