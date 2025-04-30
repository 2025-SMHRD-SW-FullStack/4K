package model;

public class Top_RankDTO {
	private String NICKNAME; // 닉네임
	private String CHAR_NAME; // 캐릭터 이름
	private int MAX_FLOOR; // 최대 층수
	
	public String getNICKNAME() {
		return NICKNAME;
	}
	
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	
	public String getCHAR_NAME() {
		return CHAR_NAME;
	}
	
	public void setCHAR_NAME(String cHAR_NAME) {
		CHAR_NAME = cHAR_NAME;
	}
	
	public int getMAX_FLOOR() {
		return MAX_FLOOR;
	}
	
	public void setMAX_FLOOR(int mAX_FLOOR) {
		MAX_FLOOR = mAX_FLOOR;
	}
}
