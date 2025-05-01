package controller;

import java.util.Scanner;

import model.EventDAO;
import model.UserCharDTO;

public class Event{

	EventDAO eDao;
	Scanner sc;
	int floor;
	
	private UserCharDTO user;

    public Event(UserCharDTO user,int floor) {
    	this.eDao = new EventDAO();
    	this.sc = new Scanner(System.in);
        this.user = user;
        this.floor = floor;
    }

	// 골드 획득
	public void addGold() {
		int giveGold = 50;
		
		eDao.addGoldSql(user,giveGold);
		user.setGOLD_HELD(user.getGOLD_HELD() + giveGold);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("%d골드를 획득하였습니다! %n",giveGold);
		System.out.println((user.getGOLD_HELD() - giveGold) + " -> " + user.getGOLD_HELD());
	}

	// 리스크있는 골드 획득
	public void curseGold() {
		int select = 0;
		int firstSelGold = 50;
		int secondSelGold = 100;
		int nowHp = 10;
		int maxHp = 10;
		boolean maxHpCheck = false;
		boolean hpCheck = false;
		System.out.printf("현재 층 : %d층 %n",floor);
		while (true) {
			System.out.println("어느 보상을 받으시겠습니까?");
			System.out.printf("[1] 현재 체력을 %d깍고 골드 %d을 받는다. %n",nowHp,firstSelGold);
			System.out.printf("[2] 최대 체력 %d을 깍고 골드 %d을 받는다. %n",maxHp,secondSelGold);
			System.out.println("[3] 아무것도 선택하지 않는다.");

			if (user.getNOW_HP() > nowHp)
				hpCheck = true;
			if (user.getUSER_HP() > maxHp)
				maxHpCheck = true;

			select = sc.nextInt();

			if (select == 1) {
				if (hpCheck) {
					user.setNOW_HP(user.getNOW_HP() - nowHp);
					user.setGOLD_HELD(user.getGOLD_HELD() + firstSelGold);
					eDao.curseGoldNowHpSql(user,nowHp, firstSelGold);
					System.out.printf("체력 %d을 읽고 %d골드를 받았습니다! %n", nowHp, user.getGOLD_HELD());
					System.out.printf("%d -> %d %n", user.getNOW_HP() + nowHp, user.getNOW_HP());
					System.out.printf("%d -> %d %n", user.getGOLD_HELD() - firstSelGold, user.getGOLD_HELD());
					break;
				} else {
					System.out.println("체력이 부족합니다.");
				}
			} else if (select == 2) {
				if (maxHpCheck) {
					user.setUSER_HP(user.getUSER_HP() - maxHp);
					if (user.getNOW_HP() > user.getUSER_HP())
						user.setNOW_HP(user.getUSER_HP());
					user.setGOLD_HELD(user.getGOLD_HELD() + secondSelGold);
					eDao.curseGoldNowHpSql(user,maxHp, secondSelGold);
					System.out.printf("최대 체력이 %d 잃고 %d 골드를 얻었습니다! %n", maxHp, secondSelGold);
					System.out.printf("%d -> %d %n", user.getUSER_HP() + maxHp, user.getUSER_HP());
					System.out.printf("%d -> %d %n", user.getGOLD_HELD() - secondSelGold, user.getGOLD_HELD());
					break;
				} else {
					System.out.println("최대 체력이 낮습니다.");
				}
			} else {
				System.out.println("선택하지 않고 넘어갔습니다!");
				break;
			}
		}

	}

	// 현재 체력 회복
	public void addHP() {
		int healHp = 10;
		int nowHp = user.getNOW_HP();
		int hp = nowHp + healHp;
		if(hp > user.getUSER_HP()) user.setNOW_HP(user.getUSER_HP());
		user.setNOW_HP(hp);
		eDao.addHpSql(user,healHp);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("체력을 %d 회복했습니다! %n", healHp);
		System.out.printf("%d -> %d %n",nowHp, hp);
	}

	// 최대 체력 증가
	public void addMaxHP() {
		int addHp = 50;
		eDao.addMaxHpSql(user,addHp);
		user.setUSER_HP(user.getUSER_HP() + addHp);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("최대 채력이 %d만큼 증가하였습니다! %n", addHp);
		System.out.printf("%d -> %d %n", user.getUSER_HP() - addHp, user.getUSER_HP());
	}

	// 골드 뻇기
	public void subGold() {
		int subGold = 50;
		int nowGold = user.getGOLD_HELD();
		int gold = nowGold - subGold;
		if(gold < 0) gold = 0;
		eDao.subGoldSql(user,subGold);
		user.setGOLD_HELD(gold);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("%d 만큼 골드를 뺏겼습니다! %n",subGold);
		System.out.printf("%d -> %d %n",nowGold,gold);
	}
	
	// 공격력 뺏기
	public void subAtk() {
		int subAtk = 10;
		int nowAtk = user.getUSER_ATK();
		int atk = nowAtk - subAtk;
		if(atk <= 1) atk = 1;
		eDao.subAtkSql(user,subAtk);
		user.setUSER_ATK(user.getUSER_ATK() - subAtk);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("%d 만큼 공격력이 낮아졌습니다! %n",subAtk);
		System.out.printf("%d -> %d %n",nowAtk,atk);
	}
	
	// 공격력 더하기
	public void sumAtk() {
		int sumAtk = 10;
		eDao.sumAtkSql(user,sumAtk);
		user.setUSER_ATK(user.getUSER_ATK() + sumAtk);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("%d 만큼 공격력이 높아졌습니다! %n",sumAtk);
	}
	
	// 방어력 뺏기
	public void subDef() {
		int subDef = 10;
		int nowDef = user.getUSER_DEF();
		int def = nowDef - subDef;
		if(def <= 1) def = 1;
		eDao.subDefSql(user,subDef);
		user.setUSER_DEF(user.getUSER_DEF() - subDef);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("%d 만큼 방어력이 낮아졌습니다! %n",subDef);
		System.out.printf("%d -> %d %n",nowDef,def);
	}
	
	// 방어력 더하기
	public void sumDef() {
		int sumDef = 10;
		eDao.sumDefSql(user,sumDef);
		user.setUSER_DEF(user.getUSER_DEF() + sumDef);
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.printf("%d 만큼 방어력이 증가했습니다! %n",sumDef);
	}
	
	// 리스크 있는 공격력 올리기
	public void curseAtk() {
		int select = 0;
		int subDef = 10;
		int subMaxHp = 10;
		int addAtk = 10;
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.println("보상을 선택하세요");
		System.out.printf("[1] 방어력을 %d 만큼 낮추고 공격력을 %d 만큼 올립니다.%n",subDef,addAtk);
		System.out.printf("[2] 최대 체력을 %d 만큼 낮추고 공격력을 %d 만큼 올립니다.%n",subMaxHp,addAtk);
		System.out.println("[3] 선택하지 않는다.");
		select = sc.nextInt();
		while(true) {
			if(select == 1) {
				eDao.subDefAddAtkSql(user,subDef,addAtk);
				user.setUSER_DEF(user.getUSER_DEF() - subDef);
				user.setUSER_HP(user.getUSER_ATK() + addAtk);
				System.out.println("능력치가 변경되었습니다!");
				System.out.printf("방어력 : %d -> %d%n",user.getUSER_DEF()+subDef,user.getUSER_DEF());
				System.out.printf("공격력 : %d -> %d%n",user.getUSER_ATK()-addAtk,user.getUSER_ATK());
				break;
			}
			if(select == 2) {
				if(user.getUSER_HP() > subMaxHp) {
					eDao.subMaxHpAddAtkSql(user,subMaxHp, addAtk);
					user.setUSER_HP(user.getUSER_HP() - subMaxHp);
					user.setUSER_ATK(user.getUSER_ATK() + addAtk);
					System.out.println("능력치가 변경되었습니다!");
					System.out.printf("최대체력 : %d -> %d%n",user.getUSER_HP()+subMaxHp,user.getUSER_HP());
					System.out.printf("공격력 : %d -> %d%n",user.getUSER_ATK()-addAtk,user.getUSER_ATK());
					break;
				}else {
					System.out.println("최대 체력이 낮습니다.");
				}
			}else {
				System.out.println("보상을 선택하지 않고 넘어갑니다.");
				break;
			}
		}
		
	}
	
	// 능력치 선택
	public void abilChoise() {
		int maxHp = 10;
		int atk = 10;
		int def = 10;
		int select = 0;
		System.out.printf("현재 층 : %d층 %n",floor);
		System.out.println("보상을 선택하세요!");
		System.out.printf("[1] 최대 체력 %d 증가 [2] 공격력 %d 증가 [3] 방어력 %d 증가 %n",maxHp,atk,def);
		System.out.println("[4] 나가기 (하나만 고를 수 있습니다.)");
		select = sc.nextInt();
		if(select == 1) {
			eDao.addMaxHpSql(user,maxHp);
			user.setUSER_HP(user.getUSER_HP()+maxHp);
			System.out.println("최대 체력이 증가하였습니다!");
			System.out.printf("최대 체력 : %d -> %d %n",user.getUSER_HP()-maxHp,user.getUSER_HP());
		}else if(select == 2) {
			eDao.sumAtkSql(user,atk);
			user.setUSER_ATK(user.getUSER_ATK()+atk);
			System.out.println("공격력이 증가했습니다!");
			System.out.printf("공격력 : %d -> %d %n",user.getUSER_ATK()-atk,user.getUSER_ATK());
		}else if(select == 3) {
			eDao.sumDefSql(user,def);
			user.setUSER_DEF(user.getUSER_DEF()+def);
			System.out.println("방어력이 증가했습니다!");
			System.out.printf("방어력 : %d -> %d %n",user.getUSER_DEF()-def,user.getUSER_DEF());
		}else {
			System.out.println("선택하지 않았습니다.");
		}
	}
	

	
}
