package model;

public class TopDTO {
	private String MON_NAME; // 몬스터 이름
	private int MON_ATK; // 몬스터 공격력
	private int MON_DEF; // 몬스터 방어력
	private int MON_HP; // 몬스터 체력
	private int DROP_GOLD; // 드랍 골드
	private String EVENT;  // 이벤트(Y/N)
	private int TOP_EXP; // 클리어시 받는 경험치
	
	public String getMON_NAME() {
		return MON_NAME;
	}
	
	public void setMON_NAME(String mON_NAME) {
		MON_NAME = mON_NAME;
	}
	
	public int getMON_ATK() {
		return MON_ATK;
	}
	
	public void setMON_ATK(int mON_ATK) {
		MON_ATK = mON_ATK;
	}
	
	public int getMON_DEF() {
		return MON_DEF;
	}
	
	public void setMON_DEF(int mON_DEF) {
		MON_DEF = mON_DEF;
	}
	
	public int getMON_HP() {
		return MON_HP;
	}
	
	public void setMON_HP(int mON_HP) {
		MON_HP = mON_HP;
	}
	
	public int getDROP_GOLD() {
		return DROP_GOLD;
	}
	
	public void setDROP_GOLD(int dROP_GOLD) {
		DROP_GOLD = dROP_GOLD;
	}
	
	public String getEVENT() {
		return EVENT;
	}
	
	public void setEVENT(String eVENT) {
		EVENT = eVENT;
	}
	
	public int getTOP_EXP() {
		return TOP_EXP;
	}
	
	public void setTOP_EXP(int tOP_EXP) {
		TOP_EXP = tOP_EXP;
	}
	
	
}
