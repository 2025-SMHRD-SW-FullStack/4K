package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Event {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	Scanner sc = new Scanner(System.in);

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "DCL_USER";
			String pw = "12345";
			conn = DriverManager.getConnection(url, userName, pw);
//			if (conn == null) {
//				System.out.println("연결 실패");
//			} else {
//				System.out.println("연결 성공");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getclose() {

		try {
			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean addGold() {
		UserDTO dto = new UserDTO();
		getConn();

		int result = 0;

		String sql = "UPDATE USER_CHAR SET GOLD_HELD GOLD_HELD+100 WHERE SEQ_NUM=?";

		try {
			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, dto.getSeqNum());

			result = psmt.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getclose();
		}
		return false;

	}
	
	public void curseGold() {
		UserDTO dto = new UserDTO();
		getConn();
		int result = 0;
		int select = 0;
		while(true) {
			System.out.println("어느 보상을 받으시겠습니까?");
			System.out.println("[1] 현제 체력을 10깍고 골드 150을 받는다.");
			System.out.println("[2] 현제 골드 200을 잃고 최대 체력 20을 올린다.");
			select = sc.nextInt();
			if(select==1) {
				
			}
		}
		
	}
	
}
