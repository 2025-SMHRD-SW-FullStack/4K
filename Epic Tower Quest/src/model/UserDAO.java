package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

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
	
	
	public int join(String user_ID, String user_PW, String NICKNAME) {
		
		int result = 0;
		
		try {
			
			getConn();
			
			String sql = "INSERT INTO USER_TABLE VALUES (USER_SEQ.NEXTVAL,?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_ID);
			psmt.setString(2, user_PW);
			psmt.setString(3, NICKNAME);

			result = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			getclose();
		}
		return result;
	}
	
	public UserDTO login(String user_ID, String user_PW) {
		UserDTO dto = null;
		
		try {
			getConn();

			String sql = "SELECT * FROM USER_TABLE WHERE ID = ? AND PW = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, user_ID);
			psmt.setString(2, user_PW);
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new UserDTO();
				dto.setID(rs.getString("ID"));
				dto.setNICKNAME(rs.getString("nickname"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return dto;
	}

	public int deleteMember(String user_ID, String user_PW) {
		int result = 0;

		try {
			getConn();

			String sql = "DELETE FROM USER_TABLE WHERE ID = ? AND PW = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, user_ID);
			psmt.setString(2, user_PW);

			result = psmt.executeUpdate();

		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return result;
	}
	
	}
	
