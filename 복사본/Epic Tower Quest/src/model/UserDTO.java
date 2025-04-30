package model;

public class UserDTO {
	private String ID;
	private String PW;
	private String NICKNAME;
	private int seqNum;

	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getPW() {
		return PW;
	}
	
	public void setPW(String pW) {
		PW = pW;
	}
	
	public String getNICKNAME() {
		return NICKNAME;
	}
	
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	
	
	
}
