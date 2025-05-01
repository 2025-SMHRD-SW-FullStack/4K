package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class UpgradeDAO {
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

	public UpgradeDTO getUserChar(String id) {

		UpgradeDTO dto = null;

		try {
			getConn();

			String sql = "SELECT * FROM USER_CHAR WHERE id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new UpgradeDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("char_name"));
				dto.setWeapon(rs.getInt("weapon"));
				dto.setArmor(rs.getInt("armor"));
				dto.setAtk(rs.getInt("user_atk"));
				dto.setDef(rs.getInt("user_def"));
				dto.setGold(rs.getInt("gold_held"));
				dto.setHp(rs.getInt("User_Hp"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public int updateChar(UpgradeDTO dto) {

		int result = 0;

		try {
			getConn();

			String sql = "update user_char set weapon = ? , armor = ? , user_atk = ? , user_def =? , gold_held = ? where id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getWeapon());
			psmt.setInt(2, dto.getArmor());
			psmt.setInt(3, dto.getAtk());
			psmt.setInt(4, dto.getDef());
			psmt.setInt(5, dto.getGold());
			psmt.setString(6, dto.getId());

			result = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
