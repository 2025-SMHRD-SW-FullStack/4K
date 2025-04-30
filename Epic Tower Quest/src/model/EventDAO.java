package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	UserCharDTO uDto = new UserCharDTO();
	
	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "DCL_USER";
			String pw = "12345";

			conn = DriverManager.getConnection(url, userName, pw);

			if (conn == null) {
				System.out.println("연결 실패");
			} else {
				System.out.println("연결 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 사용한 자원을 반납하는 메소드
	private void getclose() {
		try {
			if(rs != null)
				rs.close();
			
			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 50골드 추가 이벤트
	public void addGoldSql() {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET GOLD_HELD GOLD_HELD+50 WHERE ID=?";
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) {
				check = true;
			}else {
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
		
	}
	
	// 리스크있는 골드 획득 이벤트
	public boolean curseGoldSql(int maxHP) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_HP =  ? WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, maxHP);
			psmt.setString(2,uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else check = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
		return check;
	}
	
	public void addMaxHpSql(int hp) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_HP = ? WHERE ID + ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hp);
			psmt.setString(2,uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else check = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
}
