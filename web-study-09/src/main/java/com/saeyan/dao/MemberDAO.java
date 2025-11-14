package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.saeyan.dto.MemberVO;

/*
 * DB연결을 담당하는 클래스
 * 싱글톤으로 객체 하나만 생성해서 공유
 * 
 */
public class MemberDAO {

	// 1. 싱글톤 패턴 : 객체를 하나만 생성
	private static MemberDAO instance = new MemberDAO();

	// 2. 외부에서 생성자 호출 못하도록 Private
	private MemberDAO() {

	}

	// 3. 외부에서 사용할 수 있도록 단일 인스턴스 제공
	public static MemberDAO getInstance() {
		return instance;
	}

	// 4. DB 연결 메소드(JDBC)
	public Connection getConnection() {

		Connection con = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1234");

			// 드라이브 로드
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// 사용자 인증시 사용되는 메소드
	public boolean userCheck(String userid, String pwd) {
		boolean result = false;

		String sql = "select pwd from member where userid = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConnection();// DB연결
			pstmt = con.prepareStatement(sql);// sql 구문 전송.. sql 에러있니 없니 체크
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 가져올 데이터 있니?
				if (rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					result = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

//아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String userid) {

		MemberVO mvo = new MemberVO();
		String sql = "select * from member where userid = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();// DB연결
			pstmt = con.prepareStatement(sql);// sql 구문 전송.. sql 에러있니 없니 체크
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mvo.setName(rs.getString("name"));
				mvo.setUserid(rs.getString("userid"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setEmail(rs.getString("email"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setAdmin(rs.getInt("admin"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("getMember : " + mvo);
		return mvo;
	}

	// ressult : -1 아디디사용 가능
	// ressult : 1 아디디사용 불가능
	public int confirmID(String userid) {

		int result = -1;

		String sql = "select userid from member where userid = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConnection();// DB연결
			pstmt = con.prepareStatement(sql);// sql 구문 전송.. sql 에러있니 없니 체크
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery(); // 가져올 데이터 있음?

			if (rs.next()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;

	}// end confirmID

	public int insertMember(MemberVO mvo) {

		int result = -1;

		String sql = "insert into member values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();// DB연결
			pstmt = con.prepareStatement(sql);// sql 구문 전송.. sql 에러있니 없니 체크
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getUserid());
			pstmt.setString(3, mvo.getPwd());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getPhone());
			pstmt.setInt(6, mvo.getAdmin());

			result = pstmt.executeUpdate(); // 가져올 데이터 있음?

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end finally

		return result;
	}// end insertMember

	public void updateMember(MemberVO mvo) {
		
		String sql = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = this.getConnection();// DB연결
			pstmt = con.prepareStatement(sql);// sql 구문 전송.. sql 에러있니 없니 체크
			
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getEmail());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setInt(4, mvo.getAdmin());
			pstmt.setString(5, mvo.getUserid());

			pstmt.executeUpdate(); // 가져올 데이터 있음?

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end finally
	}}


