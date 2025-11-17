package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	public static Connection getConnection() {
		Connection con = null;

		try {
			// 드라이브 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 연결 정보
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edudb?serverTimezone=Asia/Seoul", 
					"jdbctest",
					"1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	// select를 수행한 후 자원 반납
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			con.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt) {
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
