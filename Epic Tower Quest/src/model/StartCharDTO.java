package model;

public class StartCharDTO {
	private String CHAR_NAME; // 캐릭터 이름
	private int CHAR_ATK; // 공격력
	private int CHAR_DEF; // 방어력
	private String PERKS; // 특수능력
	
	public String getCHAR_NAME() {
		return CHAR_NAME;
	}
	
	public void setCHAR_NAME(String cHAR_NAME) {
		CHAR_NAME = cHAR_NAME;
	}
	
	public int getCHAR_ATK() {
		return CHAR_ATK;
	}
	
	public void setCHAR_ATK(int cHAR_ATK) {
		CHAR_ATK = cHAR_ATK;
	}
	
	public int getCHAR_DEF() {
		return CHAR_DEF;
	}
	
	public void setCHAR_DEF(int cHAR_DEF) {
		CHAR_DEF = cHAR_DEF;
	}
	
	public String getPERKS() {
		return PERKS;
	}
	
	public void setPERKS(String pERKS) {
		PERKS = pERKS;
	}
}
