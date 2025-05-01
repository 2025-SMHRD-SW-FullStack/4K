package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharChoiceDAO {
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


	public void charChoice(String id, String string) {

		UserCharDTO userchar_dto = null;
		
		try {
			
			getConn();
			
			String sql = "select * from start_charater where char_name = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, string);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				userchar_dto = new UserCharDTO();
				userchar_dto.setCHAR_NAME(string);
				userchar_dto.setUSER_ATK(rs.getInt("char_atk"));
				userchar_dto.setUSER_DEF(rs.getInt("char_def"));
				userchar_dto.setUSER_HP(rs.getInt("hp"));
			}
			
			sql = "insert into user_char(seq_num, id, char_name, user_atk, user_def, user_hp, lev, exp, gold_held, weapon, armor, now_hp) values (USER_CHAR_SEQ.nextval, ?, ?, ?, ?, ?, 1, 0, 0, 0, 0, ?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, string);
			psmt.setInt(3, userchar_dto.getUSER_ATK());
			psmt.setInt(4, userchar_dto.getUSER_DEF());
			psmt.setInt(5, userchar_dto.getUSER_HP());
			psmt.setInt(6, userchar_dto.getUSER_HP());
			
			int result = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
