package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	//전체 데이터 가져오기
	public List<ProductVO> selectAllProducts() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fruitList order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO pVo = null;
		
		try {
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql 구문 맵핑
			
			//4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 가져온 데이터 VO 클래스 저장
			while(rs.next()) {
				pVo = new ProductVO();
				
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setOrigin(rs.getString("origin"));
				pVo.setPictureUrl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				list.add(pVo);
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return list;
		
	}

	public void insertProduct(ProductVO pVo) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into fruitList(name, price, origin, description, pictureurl) values(?, ?, ?, ?, ?)";
		
		try {
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql맵핑
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getOrigin());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setString(5, pVo.getPictureUrl());
			
			//4. sql실행
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
	} // end insertProduct

	public ProductVO slectProductByCode(String code) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from fruitList where code = ?";
		
		ProductVO pVo = new ProductVO();
		
		try {
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql맵핑
			pstmt.setInt(1, Integer.parseInt(code));
			
			//4. sql실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setOrigin(rs.getString("origin"));
				pVo.setDescription(rs.getString("description"));
				pVo.setPictureUrl(rs.getString("pictureurl"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return pVo;
	} // end slectProductByCode

	public void updateProduct(ProductVO pVo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update fruitList set name=?, price=?, origin=?, description=?, pictureurl=? where code = ?";
		
		try {
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql맵핑
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getOrigin());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setString(5, pVo.getPictureUrl());
			pstmt.setInt(6, pVo.getCode());
			
			//4. sql실행
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
	} // end updateProduct

	public void deleteProduct(int code) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from fruitList where code = ?";
		
		try {
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql맵핑
			pstmt.setInt(1, code);
			
			//4. sql실행
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
	} // end deleteProduct
	
}
