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
			} else {
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
			getConn();
			String sql = "update user_char set user_hp = ? , now_hp = ? ,lev =?,exp = ? ,user_atk=?, user_def = ?, gold_held =? where id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getUser_hp());
			psmt.setInt(2, dto.getNow_hp());
			psmt.setInt(3, dto.getUser_level());
			psmt.setInt(4, dto.getUser_exp());
			psmt.setInt(5, dto.getUser_atk());
			psmt.setInt(6, dto.getUser_def());
			psmt.setInt(7, dto.getGold_held());
			psmt.setString(8, dto.getId());

			result = psmt.executeUpdate();
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return result;
	}

	public int battleLoseUpdate(String id, int hp) {
		int result = 0;

		try {
			getConn();
			String sql = "update user_char set now_hp = ? where id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, hp);
			psmt.setString(2, id);

			result = psmt.executeUpdate();
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return result;

	}
	
	public int rankUpdate(Top_RankDTO TRdto) {

		int result = 0;

		try {
			getConn();
			String sql = "insert into top_rank values(top_rank_seq.nextval,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, TRdto.getNICKNAME());
			psmt.setString(2, TRdto.getCHAR_NAME());
			psmt.setInt(3, TRdto.getMAX_FLOOR());

			result = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return result;
	}
}
