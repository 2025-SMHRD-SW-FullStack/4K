package controller;

import java.util.Scanner;

import model.EventDAO;
import model.UserCharDTO;

public class Event{

	Scanner sc = new Scanner(System.in);

	EventDAO eDao = new EventDAO();
	UserCharDTO uDto = new UserCharDTO();

	// 골드 획득
	public void addGold() {
		uDto.setGOLD_HELD(uDto.getGOLD_HELD() + 50);
		System.out.println("50골드를 획득하였습니다!");
		System.out.println((uDto.getGOLD_HELD() - 50) + " -> " + uDto.getGOLD_HELD());
	}

	// 리스크있는 골드 획득
	public void curseGold() {
		UserCharDTO uDto = new UserCharDTO();
		int select = 0;
		int firstSelGold = 50;
		int secondSelGold = 100;
		int firstSelHp = 10;
		int secondSelHp = 100;
		boolean maxHpCheck = false;
		boolean hpCheck = false;
		while (true) {
			System.out.println("어느 보상을 받으시겠습니까?");
			System.out.println("[1] 현재 체력을 10깍고 골드 50을 받는다.");
			System.out.println("[2] 최대 체력 10을 깍고 골드 100을 받는다.");
			System.out.println("[3] 아무것도 선택하지 않는다.");

			if (uDto.getNOW_HP() > 10)
				hpCheck = true;
			if (uDto.getUSER_HP() > 10)
				maxHpCheck = true;

			select = sc.nextInt();

			if (select == 1) {
				if (hpCheck) {
					uDto.setNOW_HP(uDto.getNOW_HP() - firstSelHp);
					uDto.setGOLD_HELD(uDto.getGOLD_HELD() + firstSelGold);
					System.out.printf("체력 %d을 읽고 %d골드를 받았습니다! %n", firstSelHp, uDto.getGOLD_HELD());
					System.out.printf("%d -> %d %n", uDto.getNOW_HP() + firstSelHp, uDto.getNOW_HP());
					System.out.printf("%d -> %d %n", uDto.getGOLD_HELD() - firstSelGold, uDto.getGOLD_HELD());
					break;
				} else {
					System.out.println("체력이 부족합니다.");
				}
			} else if (select == 2) {
				if (maxHpCheck) {
					uDto.setUSER_HP(uDto.getUSER_HP() - secondSelHp);
					eDao.curseGoldSql(uDto.getUSER_HP());
					if (uDto.getNOW_HP() > uDto.getUSER_HP())
						uDto.setNOW_HP(uDto.getUSER_HP());
					uDto.setGOLD_HELD(uDto.getGOLD_HELD() + secondSelGold);
					System.out.printf("최대 체력이 %d 잃고 %d 골드를 얻었습니다! %n", secondSelHp, secondSelGold);
					System.out.printf("%d -> %d %n", uDto.getUSER_HP() + secondSelHp, uDto.getUSER_HP());
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
		UserCharDTO uDto = new UserCharDTO();
		uDto.setNOW_HP(uDto.getNOW_HP() + healHp);
		System.out.printf("체력을 %d 회복했습니다! %n", healHp);
		System.out.printf("%d -> %d %n", uDto.getNOW_HP() - 10, uDto.getNOW_HP());
	}

	// 최대 체력 증가
	public void addMaxHP() {
		int addHp = 50;
		UserCharDTO uDto = new UserCharDTO();
		eDao.addMaxHpSql(addHp);
		System.out.printf("최대 채력이 %d만큼 증가하였습니다! %n", addHp);
		System.out.printf("%d -> %d %n", uDto.getUSER_HP() - 50, uDto.getUSER_HP());
	}

}
