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
	
	// 골드 추가
	public void addGoldSql(int gold) {
		boolean check = false;
		int result = 0;
		
		String sql = "UPDATE USER_CHAR SET GOLD_HELD = ? WHERE ID=?";
		
		try {
			getConn();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getGOLD_HELD()+gold);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) {
				check = true;
			}else {
				check = false;
				System.out.println("골드 추가 이벤트 오류");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
		
	}
	
	// 리스크 있는 골드 획득 현재 체력 뺏기
	public void curseGoldNowHpSql(int hp,int gold) {
		boolean check =false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_NOWHP = ? , GOLD_HELD = ? WHERE ID = ?";
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getNOW_HP() - hp);
			psmt.setInt(2, uDto.getGOLD_HELD() + gold);
			psmt.setString(3,uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("현재 체력 감소 및 골드 획득 이벤트 오류");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 리스크 있는 골드 획득 최대 채력 뻇기
	public void curseGoldMaxHpSql(int maxHP,int gold) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_HP =  ? , GOLD_HELD = ? WHERE ID = ?";
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, maxHP);
			psmt.setInt(2, uDto.getGOLD_HELD() + gold);
			psmt.setString(3,uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("최대 체력 감소 및 골드 획득 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 현재 체력 회복
	public void addHpSql(int hp) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET NOW_HP = ? WHERE ID = ?";
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,uDto.getNOW_HP() + hp);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("체력 회복 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 최대 체력 증가
	public void addMaxHpSql(int hp) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_HP = ? WHERE ID = ?";
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hp);
			psmt.setString(2,uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("최대 체력 증가 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 골드 뺏기
	public void subGoldSql(int gold) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET GOLD_HELD = ? WHERE ID = ?";
		
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getGOLD_HELD() + gold);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("골드 뺏기 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}

	// 공격력 뺏기
	public void subAtkSql(int atk) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_ATK = ? WHERE ID = ?";
		
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getUSER_ATK() - atk);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("공격력 뺏기 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 공격력 더하기
	public void sumAtkSql(int atk) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_ATK = ? WHERE ID = ?";
		
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  uDto.getUSER_ATK() + atk);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("공격력 더하기 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 방어력 뺏기
	public void subDefSql(int def) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_DEF = ? WHERE ID = ?";
		
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getUSER_DEF() - def);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("방어력 뺏기 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 방어력 더하기
	public void sumDefSql(int def) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_DEF = ? WHERE ID = ?";
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getUSER_DEF() + def);
			psmt.setString(2, uDto.getID());
			result = psmt.executeUpdate();
			if(result > 0) check = true;
			else {
				System.out.println("방어력 증가 이벤트 오류");
				check =false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 방어력 낮추고 공격력 올리기
	public void subDefAddAtkSql(int def,int atk) {
		boolean check = false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_DEF = ?,USER_ATK = ? WHERE ID = ?";
		try {
			getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getUSER_DEF() - def);
			psmt.setInt(2, uDto.getUSER_ATK() + atk);
			psmt.setString(3, uDto.getID());
			if(result > 0) check = true;
			else {
				System.out.println("방어력 낮추고 공격력 올리기 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
	
	// 최대 체력 낮추고 공격력 올리기
	public void subMaxHpAddAtkSql(int hp, int atk) {
		boolean check =false;
		int result = 0;
		String sql = "UPDATE USER_CHAR SET USER_HP = ?, USER_ATK = ? WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, uDto.getUSER_HP() - hp);
			psmt.setInt(2, uDto.getUSER_ATK() + atk);
			psmt.setString(3, uDto.getID());
			if(result > 0) check = true;
			else {
				System.out.println("최대 체력 낮추고 공격력 올리기 이벤트 오류");
				check = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
	}
}
