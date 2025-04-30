package model;

public class UserCharDTO {
	private String ID; // 아이디
	private String CHAR_NAME; // 캐릭터 이름
	private int LEV; // 레벨
	private int EXP; // 유저 캐릭터 경험치
	private int GOLD_HELD; // 보유 골드
	private int USER_ATK; // 유저 캐릭터 공격력
	private int USER_DEF; // 유저 캐릭터 방어력
	private int USER_HP; // 유저 캐릭터 체력
	private int NOW_HP; // 유저 현재 체력
	private int WEAPON; // 무기 강화수치
	private int ARMOR; // 방어구 강화수치
	
	public UserCharDTO(String iD, String cHAR_NAME, int lEV, int eXP, int gOLD_HELD, int uSER_ATK, int uSER_DEF,
			int uSER_HP, int nOW_HP, int wEAPON, int aRMOR) {
		super();
		ID = iD;
		CHAR_NAME = cHAR_NAME;
		LEV = lEV;
		EXP = eXP;
		GOLD_HELD = gOLD_HELD;
		USER_ATK = uSER_ATK;
		USER_DEF = uSER_DEF;
		USER_HP = uSER_HP;
		NOW_HP = nOW_HP;
		WEAPON = wEAPON;
		ARMOR = aRMOR;
	}
	
	
	
	public UserCharDTO(String iD, String cHAR_NAME, int lEV, int eXP, int gOLD_HELD, int uSER_ATK, int uSER_DEF,
			int uSER_HP, int wEAPON, int aRMOR) {
		super();
		ID = iD;
		CHAR_NAME = cHAR_NAME;
		LEV = lEV;
		EXP = eXP;
		GOLD_HELD = gOLD_HELD;
		USER_ATK = uSER_ATK;
		USER_DEF = uSER_DEF;
		USER_HP = uSER_HP;
		WEAPON = wEAPON;
		ARMOR = aRMOR;
	}



	public UserCharDTO() {
		
	}

	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getCHAR_NAME() {
		return CHAR_NAME;
	}
	
	public void setCHAR_NAME(String cHAR_NAME) {
		CHAR_NAME = cHAR_NAME;
	}
	
	public int getLEV() {
		return LEV;
	}
	
	public void setLEV(int lEV) {
		LEV = lEV;
	}
	
	public int getEXP() {
		return EXP;
	}
	
	public void setEXP(int eXP) {
		EXP = eXP;
	}
	
	public int getGOLD_HELD() {
		return GOLD_HELD;
	}
	
	public void setGOLD_HELD(int gOLD_HELD) {
		GOLD_HELD = gOLD_HELD;
	}
	
	public int getUSER_ATK() {
		return USER_ATK;
	}
	
	public void setUSER_ATK(int uSER_ATK) {
		USER_ATK = uSER_ATK;
	}
	
	public int getUSER_DEF() {
		return USER_DEF;
	}
	
	public void setUSER_DEF(int uSER_DEF) {
		USER_DEF = uSER_DEF;
	}
	
	public int getUSER_HP() {
		return USER_HP;
	}
	
	public void setUSER_HP(int uSER_HP) {
		USER_HP = uSER_HP;
	}
	
	public int getWEAPON() {
		return WEAPON;
	}
	
	public void setWEAPON(int wEAPON) {
		WEAPON = wEAPON;
	}
	
	public int getARMOR() {
		return ARMOR;
	}
	
	public void setARMOR(int aRMOR) {
		ARMOR = aRMOR;
	}

	public int getNOW_HP() {
		return NOW_HP;
	}

	public void setNOW_HP(int nOW_HP) {
		NOW_HP = nOW_HP;
	}
	
}
