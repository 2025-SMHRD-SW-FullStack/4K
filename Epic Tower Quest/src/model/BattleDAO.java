package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BattleDAO {

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

			if (conn == null) {
				System.out.println("1연결 실패");
			} else {
				System.out.println("1연결 성공");
			}
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

	public TopDTO topMon(int num) {
		TopDTO dto = null;

		try {

			getConn();

			String sql = "select * from top where floor = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new TopDTO(rs.getInt("floor"), rs.getString("mon_name"), rs.getInt("mon_atk"),
						rs.getInt("mon_def"), rs.getInt("mon_hp"), rs.getInt("drop_gold"), rs.getString("event"),
						rs.getInt("top_exp"));
			}else {
				System.out.println("불러오기실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			getclose();
		}
		return dto;
	}

	public UserCharDTO userCharDto(String id) {
		UserCharDTO dto = null;

		try {

			getConn();

			String sql = "select * from user_char where id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new UserCharDTO(rs.getString("id"), rs.getString("char_name"), rs.getInt("lev"), rs.getInt("exp"),
						rs.getInt("gold_held"), rs.getInt("user_atk"), rs.getInt("user_def"), rs.getInt("user_hp"),
						rs.getInt("now_hp"));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			getclose();
		}
		return dto;
	}
	
	public int battleEndUpdate(BattleDTO dto) {
		int result = 0;

		try {
			System.out.println("여기까지 오나 체크");
			getConn();
			String sql = "update user_char set now_hp = ? ,user_atk=?, user_def = ?, gold_held =? where id = ?";

			psmt = conn.prepareStatement(sql);
			System.out.println("여기까지도 오나 체크");

			psmt.setInt(1, dto.getNow_hp());
			psmt.setInt(2, dto.getUser_atk());
			psmt.setInt(3, dto.getUser_def());
			psmt.setInt(4, dto.getGold_held());
			psmt.setString(5, dto.getId());
			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("유저 정보 수정 성공");
			} else {
				System.out.println("유저 정보 수정 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return result;
	}
}
