package controller;

import java.util.Random;
import java.util.Scanner;

import model.UpgradeDAO;
import model.UpgradeDTO;

public class Upgrade {
	// 유저의 시퀀스 넘버를 불러와서 무기 강화 수치 방어구 강화수치 올리기

	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	UpgradeDAO dao = new UpgradeDAO();

	public void userCmd(String id) {
		while (true) {
			System.out.println("[1]무기강화 [2]방어구강화 [3]나가기");
			int input = sc.nextInt();

			UpgradeDTO info = dao.getUserChar(id);
			Random ran = new Random();

			if (input == 1) {
				// 무기 강화
				if (info.getWeapon() < 3) {
					upgradeWeapon(info, 2, 1);
					dao.updateChar(info);
				} else if (info.getWeapon() < 6) {
					upgradeWeapon(info, 4, 0.9);
					dao.updateChar(info);
				} else if (info.getWeapon() < 11) {
					upgradeWeapon(info, 6, 0.7);
					dao.updateChar(info);
				} else if (info.getWeapon() < 10) {
					upgradeWeapon(info, 8, 0.55);
					dao.updateChar(info);
				} else if (info.getWeapon() < 16) {
					upgradeWeapon(info, 9, 0.3);
					dao.updateChar(info);
				} else if (info.getWeapon() < 20) {
					upgradeWeapon(info, 10, 0.15);
					dao.updateChar(info);
				} else if (info.getWeapon() < 25) {
					upgradeWeapon(info, 11, 0.05);
					dao.updateChar(info);
				} else {
					System.out.println("더 이상 강화할 수 없네.");
				}

			} else if (input == 2) {
				// 방어구 강화
				if (info.getArmor() < 3) {
					upgradeArmor(info, 2, 1);
					dao.updateChar(info);
				} else if (info.getArmor() < 6) {
					upgradeArmor(info, 4, 0.9);
					dao.updateChar(info);
				} else if (info.getArmor() < 11) {
					upgradeArmor(info, 6, 0.7);
					dao.updateChar(info);
				} else if (info.getArmor() < 10) {
					upgradeArmor(info, 8, 0.55);
					dao.updateChar(info);
				} else if (info.getArmor() < 16) {
					upgradeArmor(info, 9, 0.3);
					dao.updateChar(info);
				} else if (info.getArmor() < 20) {
					upgradeArmor(info, 10, 0.15);
					dao.updateChar(info);
				} else if (info.getArmor() < 25) {
					upgradeArmor(info, 11, 0.05);
					dao.updateChar(info);
				} else {
					System.out.println("더 이상 강화할 수 없네.");
				}

			} else if (input == 3) {
				System.out.println("잘가시게, 다음에 또 봅세.");
				break;
			}

		}

	}

	public void upgradeArmor(UpgradeDTO info, int price, double percent) {

		if (info.getGold() < price) {
			System.out.println("강화할 골드가 부족하네. 다음에 다시 오시게나.");
		} else {
			info.setGold(info.getGold() - price);
			dao.updateChar(info);
			if (ran.nextDouble(1) < percent) {
				info.setArmor(info.getArmor() + 1);
				info.setDef(info.getDef() + 2);
				dao.updateChar(info);
				System.out.println("강화에 성공했다네!");
			} else {
				System.out.println("흠.. 흠..  원숭이도 나무에서 떨어지는법...");
			}
		}
	}

	public void upgradeWeapon(UpgradeDTO info, int price, double percent) {

		if (info.getGold() < price) {
			System.out.println("강화할 골드가 부족하네. 다음에 다시 오시게나.");
		} else {
			info.setGold(info.getGold() - price);
			if (ran.nextDouble(1) < percent) {
				info.setWeapon((info.getWeapon() + 1));
				info.setAtk((info.getAtk() + 3));
				System.out.println("강화에 성공했다네!");
			} else {
				System.out.println("흠.. 흠..  원숭이도 나무에서 떨어지는법...");
			}

		}
	}
}
