package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Top_RankDAO {
	
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
	
	public ArrayList<String> showRankSql() {
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			getConn();
			String sql = "select * from (select * from top_rank order by max_floor desc) where rownum <= 10";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("NICKNAME")+"\t"+rs.getString("CHAR_NAME")+"\t"+rs.getInt("MAX_FLOOR"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
		return list;
	}
	
}
