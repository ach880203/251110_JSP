package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	
	//전체 데이터 가져오기.
	@SuppressWarnings("null")
	public List<ProductVO> selectAllProducts() {
	
	 Connection con = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 String sql = "select * from product order by code desc";
	 
	 List<ProductVO> list = new ArrayList<ProductVO>();
	 
	 ProductVO vo = null;
	 
	 
	 try {
		 //DB연결
		 con = DBManager.getConnection();
		 //sql구문 전송
		 pstmt = con.prepareStatement(sql);
		 //sql 구문 맵핑
		 
		 //sql실행
		 rs = pstmt.executeQuery();
		 
		 //가져온 데이타가 V 크래스 저장
		 while(rs.next()){
			 vo = new ProductVO();
			 
			 vo.setCode(rs.getInt("code"));
			 vo.setName(rs.getString("name"));
			 vo.setPrice(rs.getInt("price"));
			 vo.setPictureUrl(rs.getString("pictureurl"));
			 vo.setDescription(rs.getString("description"));
			 
			 list.add(vo);			 
		 }
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 DBManager.close(con, pstmt, rs);
	 }
	 return list;
}

	public void insertProduct(ProductVO vo) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into product(name, price, pictureurl, description) "
				+ "values(?, ?, ?, ?)";
		
		try {
			//DB연결
			con = DBManager.getConnection();
			
			//2.sql전송
			pstmt = con.prepareStatement(sql);
			
			//3.sql맵핑
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getPictureUrl());
			pstmt.setString(4, vo.getDescription());
			
			//4. sql실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
		
		
		
		
		
	}
}
