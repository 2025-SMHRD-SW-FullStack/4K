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
			int uSER_HP, int nOW_HP) {
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
	}

	public void JeongInfo(String dPoint) {

		switch (dPoint) {
		case "info": {
			System.out.println("정시우 (Jeong Si-woo)");
			System.out.println("나이 : 20세");
			System.out.println("대학생");
			System.out.println();
			System.out.println("서울에서 평범한 대학생활을 하던 중, 답이 나타난 날 우연히 첫 등반자로 선택되었다.");
			System.out.println("탑의 정상에 오르면 어떤 소원이든 들어준다는 관리자의 말에");
			System.out.println("어릴 적 실종된 여동생을 찾기 위해 탑을 오르게 되었다.");
			System.out.println();
			System.out.println("평소에는 조용하고 눈에 띄지 않지만, 극한 상황에서는 놀라운 집중력과 판단력을 보여준다.");
			System.out.println();
			System.out.println("특수능력 : [ 시간지연 ]");
			System.out.println("\t 상대의 시간을 느리게 만듭니다.");
			System.out.println("\t 해당 턴에 공격 횟수가 늘어납니다.");
			break;
		}

		case "pr": {
			System.out.println("비 오는 여름밤, 서울 강남 한복판에 거대한 탑이 솟아올랐다.");
			System.out.println("모두가 두려움에 움츠러든 순간, 정시우는 인파 속에서 탑을 올려보았다.");
			System.out.println("무언가에 홀린 듯 발걸음이 탑을 향했다.");
			System.out.println();
			System.out.println("  [[ 정시우 씨. 선택되었습니다. ]]  ");
			System.out.println();
			System.out.println("귓가에 울린 정체불명의 목소리.");
			System.out.println("그 순간, 시우의 눈앞에 펼쳐진 것은 낯선 회색의 세계였다.");
			System.out.println("그리고 그는 깨달았다.");
			System.out.println("여기서, 여동생을 찾을 수 있다는 것을.");
			break;
		}

		case "ep": {
			System.out.println("탑의 정상, 흰 안개로 가득한 공간이다.");
			System.out.println("시우는 조용히 앞으로 나아가, 눈앞에 떠오른 과거의 환영을 바라본다.");
			System.out.println("그곳엔 어린 시절의 여동생이 웃고 있다.");
			System.out.println();
			System.out.println("정시우는 낮게, 마치 혼잣말하듯 속삭였다.");
			System.out.println("\"내가 오랫동안 따라왔던 건...");
			System.out.println("그리움이 아니라");
			System.out.println("너를 마주할 용기였구나.\"");
			System.out.println();
			System.out.println("환영은 사라지고, 공간 전체가 푸른 하늘로 열리며 햇살이 쏟아진다.");
			System.out.println();
			System.out.println("    [[ 너는 과거를 내려놓고, 미래를 선택했다. ]]    ");
			break;
		}
		}
	}

	public void KimInfo(String dPoint) {

		switch (dPoint) {
		case "info": {
			System.out.println("김하윤 (Kim Ha-yoon)");
			System.out.println("나이 : 28세");
			System.out.println("전직 특전사 → 민간 경호업체 직원");
			System.out.println();
			System.out.println("군에서 퇴역한 후 안정된 삶을 원했으나, 탑의 출현 이후 다시 싸움에 휘말리게 되었다.");
			System.out.println();
			System.out.println("강인한 체력을 가졌으며 실전 경험이 풍부하다.");
			System.out.println("다혈질처럼 보이지만 팀을 우선을 생각하는 리더십을 지녔다.");
			System.out.println();
			System.out.println("특수능력 : [강철의 힘]");
			System.out.println("\t 육체를 강철과 같이 만듭니다.");
			System.out.println("\t 해당 턴에 받는 피해를 대폭 감소시킵니다.");
			break;
		}
		
		case "pr" : {
			System.out.println("'일상'이라는 단어가 가장 어울릴 것 같았던 평범한 아침.");
			System.out.println("하윤은 경호 업무를 위해 청담동 고급 빌딩으로 향하고 있었다.");
			System.out.println("그러나 갑자기 지하철이 급정거하고, 휴대폰 화면이 하얗게 빛났다.");
			System.out.println();
			System.out.println("    [[ 답이 열렸습니다. 등반 여부를 선택하십시오 ]]      ");
			System.out.println();
			System.out.println("본능적으로 느껴졌다.");
			System.out.println("군 시절, 죽어간 동료들이 마지막까지 지켜내려 했던 '무언가'가 저 안에 있다는 걸.");
			System.out.println();
			System.out.println("하윤은 주먹을 꽊 쥐고 탑의 입구를 향애 달렸다.");
			System.out.println("이번엔 지켜내겠다. 무엇이든.");
			break;
		}
		
		case "ep" : {
			System.out.println("폐허 같은 전장의 풍경.");
			System.out.println("하윤은 피투성이가 된 채 무릎을 꿇었다.");
			System.out.println("그의 앞에는 생전에 구하지 못한 전우들의 환영이 서 있다.");
			System.out.println();
			System.out.println("하윤은 이를 악물며 말했다");
			System.out.println("\"이번엔… 나 혼자 살아남은 게 아니다.");
			System.out.println("함께한 기억이, 나를 여기까지 이끈 거야.\"");
			System.out.println();
			System.out.println("전우들의 환영이 웃으며 사라지고, 그 자리에 피지 않았던 꽃들이 피어난다.");
			System.out.println();
			System.out.println("    [[ 너는 죄책이 아닌 용기를 선택했다. ]]    ");
			break;
		}
		}

	}
	
	public void SeoInfo(String dPoint) {
		switch(dPoint) {
			
		case "info" : {
			System.out.println("서이담 (Seo I-dam)");
			System.out.println("나이 : 17세");
			System.out.println("고등학생");
			System.out.println();
			System.out.println("천재적인 수학, 논리 능력으로 '탑 해커'라 불리고 있다.");
			System.out.println("처음엔 게임처럼 생각했지만 점점 현실과 맞닿은 공포에 눈을 뜨게되었다.");
			System.out.println();
			System.out.println("말수가 적고 차가운 인상을 가졌다.");
			System.out.println("감정을 드러내지 않지만, 누구보다 빠르게 상황을 계산한다.");
			System.out.println();
			System.out.println("특수능력 : [ 패턴감지 ]");
			System.out.println("\t 상대의 공격을 예측할 수 있게 됩니다.");
			System.out.println("\t 상대의 공격을 회피할 확률을 얻습니다.");
			
			break;
		}
		
		case "pr" : {
			System.out.println("평소와 다름없는 등굣길, 서이담은 하늘을 보았다.");
			System.out.println("거대한 구조물이 구름을 뚫고 솟아오르는 장면을, 모두가 핸드폰으로 찍고 있었다.");
			System.out.println("하지만 이담은, 그저 숫자처럼 보았다.");
			System.out.println();
			System.out.println("'높이 432m. 변위 속도 초당 1.2m. 형태는 프랙탈 구조...'");
			System.out.println();
			System.out.println("학교에 도착했을 때, 이담은 메시지를 받았다.");
			System.out.println("    [[ 탑 알고리즘 해독자 후보로 선발되었습니다. ]]    ");
			System.out.println();
			System.out.println("그는 고개를 끄덕였다.");
			System.out.println("재밌겠군. 드디어 풀어야 할 퍼즐이 생겼다.");
			
			break;
		}
		
		case "ep" : {
			System.out.println("완전한 정적 속 수학 공식과 미지의 기호가 떠다니는 공간이다.");
			System.out.println("이담은 그것들을 천천히 바라보다가, 문득 고개를 들었다.");
			System.out.println();
			System.out.println("서이담은 차분한 목소리로 말했다.");
			System.out.println("\"탑은 답이 아니었어.");
			System.out.println("그저 나를 이해하게 만든 질문이었지.\"");
			System.out.println();
			System.out.println("기호들이 하나씩 사라지고, 거대한 거울이 나타난다.");
			System.out.println("거울 속엔 '지금의 자신'이 미소를 짓고 있다.");
			System.out.println();
			System.out.println("    [[ 너는 해석이 아닌, 존재를 선택했다. ]]    ");
		}
		
		}
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
