package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MemberVO;
import util.DBManager;

public class MemberDAO {

    private MemberDAO() {}
    private static MemberDAO instance = new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }

    // -----------------------
    // 1) 회원가입
    // -----------------------
    
    /*
     * id INT AUTO_INCREMENT PRIMARY KEY,   
        name VARCHAR(50),
        user_id VARCHAR(50),
        user_pw VARCHAR(100),
        nick VARCHAR(30),
        phone VARCHAR(20),

        email VARCHAR(100),
        reg_date DATE,
        address VARCHAR(200)
     */
    public void insertMember(MemberVO mvo) {
        String sql = "INSERT INTO members(name, user_id, user_pw, nick, phone, email, admin, reg_date, address) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, mvo.getName());
            pstmt.setString(2, mvo.getUserId());
            pstmt.setString(3, mvo.getUserpw());
            pstmt.setString(4, mvo.getNick());
            pstmt.setString(5, mvo.getPhone());
            pstmt.setString(6, mvo.getEmail());
            int adminValue = (mvo.getAdmin() == 0) ? 0 : mvo.getAdmin();
            pstmt.setInt(7, adminValue);
            pstmt.setString(8, mvo.getAddress());
           
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    // -----------------------
    // 2) ID 중복 체크
    // -----------------------
    public int confirmId(String userId) {
        String sql = "SELECT user_id FROM members WHERE user_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int result = -1; // 사용 가능

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = 1; // 중복
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return result;
    }

    // -----------------------
    // 3) 전체 회원 조회 (회원관리 페이지)
    // -----------------------
    public List<MemberVO> selectAllMembers() {
        String sql = "SELECT * FROM members ORDER BY id ASC";

        List<MemberVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberVO mvo = new MemberVO();
                mvo.setMemberId(rs.getInt("id"));
                mvo.setName(rs.getString("name"));
                mvo.setUserId(rs.getString("user_id"));
                mvo.setUserpw(rs.getString("user_pw"));
                mvo.setNick(rs.getString("nick"));
                mvo.setPhone(rs.getString("phone"));
                mvo.setEmail(rs.getString("email"));
                mvo.setAdmin(rs.getInt("admin"));
                mvo.setRegDate(rs.getString("reg_date"));
                mvo.setAddress(rs.getString("address"));
                list.add(mvo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return list;
    }

    // -----------------------
    // 4) userId로 회원 한 명 조회 (상세/수정 페이지)
    // -----------------------
    public MemberVO getMember(String userId) {
        String sql = "SELECT * FROM members WHERE user_id = ?";

        MemberVO vo = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                vo = new MemberVO();
                vo.setMemberId(rs.getInt("id"));
                vo.setName(rs.getString("name"));
                vo.setUserId(rs.getString("user_id"));
                vo.setUserpw(rs.getString("user_pw"));
                vo.setNick(rs.getString("nick"));
                vo.setPhone(rs.getString("phone"));
                vo.setEmail(rs.getString("email"));
                vo.setAdmin(rs.getInt("admin"));
                vo.setRegDate(rs.getString("reg_date"));
                vo.setAddress(rs.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return vo;
    }

    // -----------------------
    // 5) 회원정보 업데이트
    // -----------------------
    public void updateMember(MemberVO mvo) {
       String sql = "UPDATE members SET name=?, user_pw=?, phone=?, nick=?, email=?, admin=?, address=? WHERE user_id=?";


        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, mvo.getName());
            pstmt.setString(2, mvo.getUserpw());
            pstmt.setString(3, mvo.getPhone());
            pstmt.setString(4, mvo.getNick());
            pstmt.setString(5, mvo.getEmail());
            pstmt.setInt(6, mvo.getAdmin());
            pstmt.setString(7, mvo.getAddress());
            pstmt.setString(8, mvo.getUserId());


            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
    // -----------------------
    // 6) 아이디 찾기 (이름 + 이메일)
    // -----------------------
    public String findIdByNameAndEmail(String name, String email) {
        String sql = "SELECT user_id FROM members WHERE name = ? AND email = ?";
        String userId = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userId = rs.getString("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return userId;
    }
    // -----------------------
    // 7) 비밀번호 찾기 (아이디 + 이메일)
    // -----------------------
    public String findPwByIdAndEmail(String userId, String email) {
        String sql = "SELECT user_pw FROM members WHERE user_id = ? AND email = ?";
        String userPw = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userPw = rs.getString("user_pw");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return userPw;
    }

    public MemberVO getMemberByUserId(String user_id) {

        MemberVO mvo = null;
        String sql = "SELECT * FROM members WHERE user_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                mvo = new MemberVO();
                mvo.setMemberId(rs.getInt("id"));
                mvo.setName(rs.getString("name"));
                mvo.setUserId(rs.getString("user_id"));
                mvo.setUserpw(rs.getString("user_pw"));
                mvo.setNick(rs.getString("nick"));
                mvo.setPhone(rs.getString("phone"));
                mvo.setEmail(rs.getString("email"));
                mvo.setAdmin(rs.getInt("admin"));
                mvo.setRegDate(rs.getString("reg_date"));
                mvo.setAddress(rs.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return mvo;
    }

    public void deletemember(String userId) {
        
        String sql = "delete from members where user_id=?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
           conn = DBManager.getConnection();
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, userId);
           
           pstmt.executeUpdate();
           
        }catch (Exception e) {
           e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
        
     }

	public MemberVO userCheck(String userId, String userPw) {
        String sql = "SELECT * FROM members WHERE user_id = ? AND user_pw = ?";
        MemberVO vo = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                vo = new MemberVO();
                vo.setMemberId(rs.getInt("id"));
                vo.setName(rs.getString("name"));
                vo.setUserId(rs.getString("user_id"));
                vo.setUserpw(rs.getString("user_pw"));
                vo.setPhone(rs.getString("phone"));
                vo.setEmail(rs.getString("email"));
                vo.setRegDate(rs.getString("reg_date"));
                vo.setAddress(rs.getString("address"));
                vo.setNick(rs.getString("nick"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return vo;
	}



}