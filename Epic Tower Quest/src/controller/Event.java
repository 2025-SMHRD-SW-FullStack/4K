package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.UserCharDTO;
import model.UserDAO;
import model.UserDTO;


public class Event extends UserDAO{

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	Scanner sc = new Scanner(System.in);

//	private void getConn() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String userName = "DCL_USER";
//			String pw = "12345";
//			conn = DriverManager.getConnection(url, userName, pw);
//			if (conn == null) {
//				System.out.println("연결 실패");
//			} else {
//				System.out.println("연결 성공");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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
		UserCharDTO dto = new UserCharDTO();

		int result = 0;

		String sql = "UPDATE USER_CHAR SET GOLD_HELD GOLD_HELD+50 WHERE SEQ_NUM=?";

		try {
			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, dto.getSeqNum());
			result = psmt.executeUpdate();
			if (result > 0) {
				dto.setGOLD_HELD(dto.getGOLD_HELD()+50);
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
		UserCharDTO dto = new UserCharDTO();
		int result = 0;
		int select = 0;
		boolean goldCheck = false;
		boolean hpCheck = false;
		while (true) {
			System.out.println("어느 보상을 받으시겠습니까?");
			System.out.println("[1] 현재 체력을 10깍고 골드 50을 받는다.");
			System.out.println("[2] 현재 골드 50을 잃고 최대 체력 20을 올린다.");
			select = sc.nextInt();

			if (select == 1) {
//				if(dto.getNOW_HP > 10) hpCheck = true;
				if(hpCheck) {
					
				dto = new UserCharDTO();
				String sql = "UPDATE USER_CHAR SET GOLD_HELD GOLD_HELD + 50 WHERE SEQ_NUM=?";
				try {
					psmt = conn.prepareStatement(sql);
//					psmt.setInt(1, dto.getSeqNum());
					result = psmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					getclose();
				}
				break;
				}
				else {
					System.out.println("체력이 부족합니다.");
				}
			} else if (select == 2) {
//				if (dto.getGold() >= 200)
//					goldCheck = true;
				if (goldCheck) {
					String sql = "UPDATE USER_CHAR SET GOLD_HELD GOLD_HELD-200 "
							+ "AND USER_HP USER_HP + 20 WHERE SEQ_NUM = ?";
					try {
						psmt = conn.prepareStatement(sql);
//					psmt.setInt(1, dto.getSeqNum());
						result = psmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						getclose();
					}
					break;
				} else {
					System.out.println("골드가 부족합니다.");
				}
			}else {
				
			}
		}

	}
	
	public void addHP() {
		UserCharDTO dto = new UserCharDTO();
//		dto.setHP(dto.getHP+10);
	}
	
	public void addMaxHP() {
		UserCharDTO dto = new UserCharDTO();
//		String sql = "UPDATE UPDATE USER_CHAR SET "
	}

}
