package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.NoticeVO;

import util.DBManager;

public class NoticeDAO {
	
	private static NoticeDAO instance= new NoticeDAO();
	
	private NoticeDAO() {}
	
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	public List<NoticeVO> selectAllfruits() {
		
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "select * from fruit order by num desc";
		
		 List<NoticeVO> list = new ArrayList<NoticeVO>();
		 try {
			 con = DBManager.getConnection();
			 
			 pstmt = con.prepareStatement(sql);
			 
			 rs = pstmt.executeQuery();
			 
			 /*
			  *num int primary key auto_increment,
			pass varchar(30) not null, 
			title varchar(30) , 
			date varchar (30),
			views int default 0,
			text TEXT (50)
			  */
		
		while (rs.next()) {
			NoticeVO vo = new NoticeVO();
			
			int num = rs.getInt("num");
			
			String title = rs.getString("title");
			
			vo.setNum(num);
			vo.setTitle(title);
			vo.setPass(rs.getString("pass"));
			vo.setDate(rs.getString("date"));
			vo.setViews(String.valueOf(rs.getInt("views")));
			vo.setText(rs.getString("text"));
			
			list.add(vo);
		}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBManager.close(con,pstmt,rs);
		 }
		
		return list;
		
	}

	public NoticeVO selectOneByNum(int num) {
		
		NoticeVO vo = new NoticeVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fruit where num = ?";
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
				
				/*
				  *num int primary key auto_increment,
				pass varchar(30) not null, 
				title varchar(30) , 
				date varchar (30),
				views int default 0,
				text TEXT (50)
				  */
				
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setTitle(rs.getString("title"));
				vo.setDate(rs.getString("date"));
				vo.setViews(rs.getString("views"));
				vo.setText(rs.getString("text"));
		}catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBManager.close(con,pstmt,rs);
		 }
		
		return vo;
	}

	public void updateReadCount(int num) {
		String sql = "update fruit set views = views+1 where num = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con,pstmt);
		}
		
	}

	public void insertFruit(NoticeVO vo) {
		String sql = "insert into fruit(title,pass, date,text) "
				+ "values(?,?,?,?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			DBManager.getConnection();
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getDate());
			pstmt.setString(4, vo.getText());
			
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con,pstmt);
		}
		
		
	}

	public void deletefruit(int num) {
		
		String sql = "delete from fruit where num = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con,pstmt);
		}
	}


}
