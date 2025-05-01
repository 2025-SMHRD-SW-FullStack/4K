package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCharDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			String userName = "campus_25SW_FS_p1_2";
			String pw = "smhrd2";

			conn = DriverManager.getConnection(url, userName, pw);

// 			if (conn == null) {
// 				System.out.println("연결 실패");
// 			} else {
// 				System.out.println("연결 성공");
// 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사용한 자원을 반납하는 메소드
	private void getclose() {

		try {
			if (rs != null)
				rs.close();

			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public UserCharDTO getUserCharInfo(String id) {
		UserCharDTO dto = null;
		
		try {
			getConn();

			String sql = "SELECT * FROM USER_CHAR WHERE id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new UserCharDTO();
				dto.setID(rs.getString("id"));
				dto.setCHAR_NAME(rs.getString("char_name"));
				dto.setWEAPON(rs.getInt("weapon"));
				dto.setARMOR(rs.getInt("armor"));
				dto.setUSER_ATK(rs.getInt("user_atk"));
				dto.setUSER_DEF(rs.getInt("user_def"));
				dto.setGOLD_HELD(rs.getInt("gold_held"));
				dto.setUSER_HP(rs.getInt("User_Hp"));
				dto.setLEV(rs.getInt("LEV"));
				dto.setEXP(rs.getInt("EXP"));
				dto.setNOW_HP(rs.getInt("NOW_HP"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
}
