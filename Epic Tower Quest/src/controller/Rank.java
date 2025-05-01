package controller;


import model.Top_RankDAO;

public class Rank {
	
	Top_RankDAO tRankDao = new Top_RankDAO();
	
	public void showRank() {
		tRankDao.showRankSql();
		for(String s : tRankDao.showRankSql()) {
			System.out.println(s);
		}
	}
}
