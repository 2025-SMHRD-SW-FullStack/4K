package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.EventDAO;
import model.UserCharDTO;

public class Event{

	UserCharDTO uDto;
	EventDAO eDao;
	Scanner sc;
	
	public Event(UserCharDTO uDto) {
		this.uDto = uDto;
		this.eDao = new EventDAO();
		this.sc = new Scanner(System.in);
	}

	// 골드 획득
	public void addGold() {
		int giveGold = 50;
		
		eDao.addGoldSql(giveGold);
		uDto.setGOLD_HELD(uDto.getGOLD_HELD() + giveGold);
		System.out.printf("%d골드를 획득하였습니다! %n",giveGold);
		System.out.println((uDto.getGOLD_HELD() - giveGold) + " -> " + uDto.getGOLD_HELD());
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
		while (true) {
			System.out.println("어느 보상을 받으시겠습니까?");
			System.out.printf("[1] 현재 체력을 %d깍고 골드 %d을 받는다. %n",nowHp,firstSelGold);
			System.out.printf("[2] 최대 체력 %d을 깍고 골드 %d을 받는다. %n",maxHp,secondSelGold);
			System.out.println("[3] 아무것도 선택하지 않는다.");

			if (uDto.getNOW_HP() > nowHp)
				hpCheck = true;
			if (uDto.getUSER_HP() > maxHp)
				maxHpCheck = true;

			select = sc.nextInt();

			if (select == 1) {
				if (hpCheck) {
					uDto.setNOW_HP(uDto.getNOW_HP() - nowHp);
					uDto.setGOLD_HELD(uDto.getGOLD_HELD() + firstSelGold);
					eDao.curseGoldNowHpSql(nowHp, firstSelGold);
					System.out.printf("체력 %d을 읽고 %d골드를 받았습니다! %n", nowHp, uDto.getGOLD_HELD());
					System.out.printf("%d -> %d %n", uDto.getNOW_HP() + nowHp, uDto.getNOW_HP());
					System.out.printf("%d -> %d %n", uDto.getGOLD_HELD() - firstSelGold, uDto.getGOLD_HELD());
					break;
				} else {
					System.out.println("체력이 부족합니다.");
				}
			} else if (select == 2) {
				if (maxHpCheck) {
					uDto.setUSER_HP(uDto.getUSER_HP() - maxHp);
					if (uDto.getNOW_HP() > uDto.getUSER_HP())
						uDto.setNOW_HP(uDto.getUSER_HP());
					uDto.setGOLD_HELD(uDto.getGOLD_HELD() + secondSelGold);
					eDao.curseGoldNowHpSql(maxHp, secondSelGold);
					System.out.printf("최대 체력이 %d 잃고 %d 골드를 얻었습니다! %n", maxHp, secondSelGold);
					System.out.printf("%d -> %d %n", uDto.getUSER_HP() + maxHp, uDto.getUSER_HP());
					System.out.printf("%d -> %d", uDto.getGOLD_HELD() - secondSelGold, uDto.getGOLD_HELD());
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
		uDto.setNOW_HP(uDto.getNOW_HP() + healHp);
		eDao.addHpSql(healHp);
		System.out.printf("체력을 %d 회복했습니다! %n", healHp);
		System.out.printf("%d -> %d %n", uDto.getNOW_HP() - healHp, uDto.getNOW_HP());
	}

	// 최대 체력 증가
	public void addMaxHP() {
		int addHp = 50;
		eDao.addMaxHpSql(addHp);
		uDto.setUSER_HP(uDto.getUSER_HP() + addHp);
		System.out.printf("최대 채력이 %d만큼 증가하였습니다! %n", addHp);
		System.out.printf("%d -> %d %n", uDto.getUSER_HP() - addHp, uDto.getUSER_HP());
	}

	// 골드 뻇기
	public void subGold() {
		int subGold = 50;
		eDao.subGoldSql(subGold);
		uDto.setGOLD_HELD(uDto.getGOLD_HELD() - subGold);
		System.out.printf("%d 만큼 골드를 뺏겼습니다! %n",subGold);
	}
	
	// 공격력 뺏기
	public void subAtk() {
		int subAtk = 10;
		eDao.subAtkSql(subAtk);
		uDto.setUSER_ATK(uDto.getUSER_ATK() - subAtk);
		System.out.printf("%d 만큼 공격력이 낮아졌습니다! %n",subAtk);
	}
	
	// 공격력 더하기
	public void sumAtk() {
		int sumAtk = 10;
		eDao.sumAtkSql(sumAtk);
		uDto.setUSER_ATK(uDto.getUSER_ATK() + sumAtk);
		System.out.printf("%d 만큼 공격력이 높아졌습니다! %n",sumAtk);
	}
	
	// 방어력 뺏기
	public void subDef() {
		int subDef = 10;
		eDao.subDefSql(subDef);
		uDto.setUSER_DEF(uDto.getUSER_DEF() - subDef);
		System.out.printf("%d 만큼 방어력이 낮아졌습니다!",subDef);
	}
	
	// 방어력 더하기
	public void sumDef() {
		int sumDef = 10;
		eDao.sumDefSql(sumDef);
		uDto.setUSER_DEF(uDto.getUSER_DEF() + sumDef);
		System.out.printf("%d 만큼 방어력이 증가했습니다!",sumDef);
	}
	
	// 리스크 있는 공격력 올리기
	public void curseAtk() {
		int select = 0;
		int subDef = 10;
		int subMaxHp = 10;
		int addAtk = 10;
		System.out.println("보상을 선택하세요");
		System.out.printf("[1] 방어력을 %d 만큼 낮추고 공격력을 %d 만큼 올립니다.%n",subDef,addAtk);
		System.out.printf("[2] 최대 체력을 %d 만큼 낮추고 공격력을 %d 만큼 올립니다.%n",subMaxHp,addAtk);
		System.out.println("[3] 선택하지 않는다.");
		select = sc.nextInt();
		while(true) {
			if(select == 1) {
				eDao.subDefAddAtkSql(subDef,addAtk);
				uDto.setUSER_DEF(uDto.getUSER_DEF() - subDef);
				uDto.setUSER_HP(uDto.getUSER_ATK() + addAtk);
				System.out.println("능력치가 변경되었습니다!");
				System.out.printf("방어력 : %d -> %d%n",uDto.getUSER_DEF()+subDef,uDto.getUSER_DEF());
				System.out.printf("공격력 : %d -> %d%n",uDto.getUSER_ATK()-addAtk,uDto.getUSER_ATK());
				break;
			}
			if(select == 2) {
				if(uDto.getUSER_HP() > subMaxHp) {
					eDao.subMaxHpAddAtkSql(subMaxHp, addAtk);
					uDto.setUSER_HP(uDto.getUSER_HP() - subMaxHp);
					uDto.setUSER_ATK(uDto.getUSER_ATK() + addAtk);
					System.out.println("능력치가 변경되었습니다!");
					System.out.printf("최대체력 : %d -> %d%n",uDto.getUSER_HP()+subMaxHp,uDto.getUSER_HP());
					System.out.printf("공격력 : %d -> %d%n",uDto.getUSER_ATK()-addAtk,uDto.getUSER_ATK());
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
	
	// 능력치 상점
	public void abilShop() {
		int maxHp = 10;
		int atk = 10;
		int def = 10;
		int select = 0;
		System.out.println("상점에 오신걸 환영합니다!");
		System.out.printf("[1] 최대 체력 %d 증가 [2] 공격력 %d 증가 [3] 방어력 %d 증가 %n",maxHp,atk,def);
		System.out.println("[4] 나가기 (하나만 구입할 수 있습니다.)");
		select = sc.nextInt();
		if(select == 1) {
			eDao.addMaxHpSql(maxHp);
			uDto.setUSER_HP(uDto.getUSER_HP()+maxHp);
			System.out.println("최대 체력이 증가하였습니다!");
			System.out.printf("최대 체력 : %d -> %d %n",uDto.getUSER_HP()-maxHp,uDto.getUSER_HP());
		}else if(select == 2) {
			eDao.sumAtkSql(atk);
			uDto.setUSER_ATK(uDto.getUSER_ATK()+atk);
			System.out.println("공격력이 증가했습니다!");
			System.out.printf("공격력 : %d -> %d %n",uDto.getUSER_ATK()-atk,uDto.getUSER_ATK());
		}else if(select == 3) {
			eDao.sumDefSql(def);
			uDto.setUSER_DEF(uDto.getUSER_DEF()+def);
			System.out.println("방어력이 증가했습니다!");
			System.out.printf("방어력 : %d -> %d %n",uDto.getUSER_DEF()-def,uDto.getUSER_DEF());
		}else {
			System.out.println("상점에서 나갔습니다.");
		}
	}
	

	
}
