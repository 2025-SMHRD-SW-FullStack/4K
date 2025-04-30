package model;

public class BattleDTO {
	// 배틀 dto에 실어서 보내야하는것
	// 아이디, 레벨, 현재체력, 공격력, 방어력, 골드
	private String id;
	private int now_hp;
	private int user_atk;
	private int user_def;
	private int gold_held;
	
	@Override
	public String toString() {
		return "BattleDTO [id=" + id + ", now_hp=" + now_hp + ", user_atk=" + user_atk + ", user_def=" + user_def
				+ ", gold_held=" + gold_held + "]";
	}

	public BattleDTO(String id, int now_hp, int user_atk, int user_def, int gold_held) {
		super();
		this.id = id;
		this.now_hp = now_hp;
		this.user_atk = user_atk;
		this.user_def = user_def;
		this.gold_held = gold_held;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNow_hp() {
		return now_hp;
	}

	public void setNow_hp(int now_hp) {
		this.now_hp = now_hp;
	}

	public int getUser_atk() {
		return user_atk;
	}

	public void setUser_atk(int user_atk) {
		this.user_atk = user_atk;
	}

	public int getUser_def() {
		return user_def;
	}

	public void setUser_def(int user_def) {
		this.user_def = user_def;
	}

	public int getGold_held() {
		return gold_held;
	}

	public void setGold_held(int gold_held) {
		this.gold_held = gold_held;
	}
	

	
}	
