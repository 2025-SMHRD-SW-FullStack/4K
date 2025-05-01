package controller;


import model.Top_RankDAO;

public class Rank {
	
	Top_RankDAO tRankDao = new Top_RankDAO();
	
	public void showRank() {
		tRankDao.showRankSql();
		System.out.println("닉네임\t캐릭터\t최대층");
		for(String s : tRankDao.showRankSql()) {
			System.out.println(s);
		}
	}
}
