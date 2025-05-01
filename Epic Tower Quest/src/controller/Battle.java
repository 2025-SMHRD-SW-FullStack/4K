package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.BattleDAO;
import model.BattleDTO;
import model.TopDTO;
import model.Top_RankDTO;
import model.UserCharDTO;
import model.UserDTO;

public class Battle {

	public boolean floorCheck(String id, String nick) {
		int floor = 1;
		BattleDAO btDao = new BattleDAO();
		Random rand = new Random();
		boolean floorCheck = true;

		while (true) {
			UserCharDTO userDto = btDao.userCharDto(id);
			if (floor % 5 == 0 && floor!=20) {
				Event e = new Event(userDto,floor);
				List<Runnable> eventList = Arrays.asList(
						() -> e.addGold(),
						() -> e.subGold(),
						() -> e.addHP(),
						() -> e.addMaxHP(),
						() -> e.curseGold(),
						() -> e.sumAtk(),
						() -> e.subAtk(),
						() -> e.sumDef(),
						() -> e.subDef(),
						() -> e.curseAtk(),
						() -> e.abilChoise()
						);
				int idx = rand.nextInt(eventList.size());
				eventList.get(idx).run();
				floor++;
			} else {

				boolean bt = battle(userDto, nick, floor);
				floor++;
				if (!bt) {
					break;
				}
			}
		}
		if(floor>20) {
			floorCheck = false;
		}
		return floorCheck;

	}

	public boolean battle(UserCharDTO userDto, String nick, int floor) {

		Scanner sc = new Scanner(System.in);

//		String user_name = "";
//		String mon_name = "";
//		int user_atk = 0;
//		int user_def = 0;
//		int user_hp = 0;
//		int mon_atk = 0;
//		int mon_def = 0;
//		int mon_hp = 0;
//		int top_level = 1;
//		boolean user_win = true;

		BattleDAO btDao = new BattleDAO();

		TopDTO topDto = btDao.topMon(floor);
		
		AscCon asc = new AscCon();
		

		String id = userDto.getID();
		String user_name = userDto.getCHAR_NAME();
		String mon_name = topDto.getMON_NAME();
		int user_atk = userDto.getUSER_ATK();
		int user_def = userDto.getUSER_DEF();
		int user_now_hp = userDto.getNOW_HP();
		int user_hp = userDto.getUSER_HP();
		int user_level = userDto.getLEV();
		int user_exp = userDto.getEXP();
		int mon_atk = topDto.getMON_ATK();
		int mon_def = topDto.getMON_DEF();
		int mon_now_hp = topDto.getMON_HP();
		int mon_hp = topDto.getMON_HP();
		int mon_exp = topDto.getTOP_EXP();
		int user_gold = userDto.getGOLD_HELD();
		int mon_gold = topDto.getDROP_GOLD();

		int turn = 1;
		boolean skillCheck = true;
		boolean siwooSkill = false;
		boolean idamSkill = false;
		boolean user_win = true;
		boolean floorCheck = true;

		if (floor > 20) {
			sleep();
			Top_RankDTO TRdto = new Top_RankDTO(nick, user_name, floor);
			btDao.rankUpdate(TRdto);
			System.out.println("탑의 꼭대기에 올랐습니다.");
			System.out.println("당신이 찾던 것이 저 앞에 있습니다-");
			floorCheck = false;
		}
		if(floorCheck) {
			sleep();
			System.out.println();
			System.out.println("====== 현재 층 : " + floor + "층 =======");
			System.out.println();
			System.out.println("적이 등장했습니다");
			System.out.println("전투 시작!");
			sleep();
			asc.img(floor);
		}
		while (floorCheck) {
			System.out.println();
			System.out.println("턴 : " + turn);
			turn++;
			System.out.println("[" + mon_name + "] 체력 : " + mon_now_hp + "/" + mon_hp);
			System.out.println("당신의 이름 : " +user_name);
			System.out.println("당신의 레벨 : " +user_level);
			System.out.println("당신의 체력 : " + user_now_hp + "/" + user_hp);
			System.out.println("당신의 공격력 : " + user_atk + " / 당신의 방어력 : " + user_def);
			int bonus_def = 0;
			int bonus_atk = 0;
			boolean bonus_crt = false;
			boolean isCrt = false;
			while (true) {
				System.out.println("[1] 방어 태세 [2] 공격 태세 [3] 특수 능력");
				int check = sc.nextInt();
				if (check == 1) {
					bonus_def = 10;
					System.out.println("방어를 굳힙니다. 추가 방어력을 얻습니다.");
					break;
				} else if (check == 2) {
					bonus_atk = 10;
					bonus_crt = true;
					System.out.println("공격 태세를 취합니다. 추가 공격력과 치명타 확률을 얻습니다");
					break;
				} else if (check == 3) {
					if (skillCheck) {
						System.out.println("고유 능력을 발동합니다.");
						System.out.println("고유 능력은 전투마다 한번만 사용할 수 있습니다");
						sleep();
						if (user_name.equals("정시우")) {
							System.out.println("[시간 지연]");
							System.out.println("상대의 시간을 느리게 만듭니다");
							System.out.println("이번 턴에 자신의 공격 횟수가 늘어납니다");
							sleep();
							siwooSkill=true;
						} else if (user_name.equals("김하윤")) {
							System.out.println("[강철의 힘]");
							System.out.println("육체를 강철과 같이 만듭니다");
							System.out.println("이번 턴에 받는 피해를 대폭 감소시킵니다.");
							sleep();
							bonus_def += 100;
						} else {
							System.out.println("[패턴 감지]");
							System.out.println("상대의 공격을 예측할 수 있게 됩니다");
							System.out.println("상대의 공격을 회피할 확률을 얻습니다.");
							sleep();
							idamSkill = true;
						}
						skillCheck = false;
					} else {
						System.out.println("이미 고유 능력을 사용했습니다.");
					}
				} else {
					System.out.println("잘못된 입력입니다.");
				}

			}
			sleep();
			if (siwooSkill) {
				System.out.println(user_name + "의 공격!");
				int basicAtk = random(user_atk);
				int mon_dmg = 0;
				if (bonus_crt) {
					if (50 < (int) (Math.random() * 100)) {
						isCrt = true;
						mon_dmg = (int) ((basicAtk + bonus_atk) * 1.2) - mon_def;
					} else {

						mon_dmg = basicAtk + bonus_atk - mon_def;
					}
				} else {
					mon_dmg = basicAtk + bonus_atk - mon_def;
				}
				if (mon_dmg > 0) {
					if (isCrt) {
						System.out.println("치명타!");
					}
					System.out.println(mon_name + "이(가) " + mon_dmg + "의 피해를 입었습니다!");
					mon_now_hp = mon_now_hp - mon_dmg;
				} else {
					System.out.println("적이 공격을 방어했습니다!");
				}
				siwooSkill=false;
			}
			System.out.println(user_name + "의 공격!");
			int basicAtk = random(user_atk);
			int mon_dmg = 0;
			if (bonus_crt) {
				if (50 < (int) (Math.random() * 100)) {
					isCrt = true;
					mon_dmg = (int) ((basicAtk + bonus_atk) * 1.2) - mon_def;
				} else {

					mon_dmg = basicAtk + bonus_atk - mon_def;
				}
			} else {
				mon_dmg = basicAtk + bonus_atk - mon_def;
			}
			if (mon_dmg > 0) {
				if (isCrt) {
					System.out.println("치명타!");
				}
				System.out.println(mon_name + "이(가) " + mon_dmg + "의 피해를 입었습니다!");
				mon_now_hp = mon_now_hp - mon_dmg;
			} else {
				System.out.println("적이 공격을 방어했습니다!");
			}
			sleep();

			if (mon_now_hp <= 0) {
				System.out.println(mon_name + "을(를) 처치했습니다!");
				user_win = true;
				break;
			}
			System.out.println(mon_name + "의 공격!");
			int monster_Atk = random(mon_atk);
			int random = (int)(Math.random()*100)+1;
			if(!idamSkill) {
				int user_dmg = monster_Atk - user_def - bonus_def;
				if (user_dmg > 0) {
					System.out.println(user_name + "이(가) " + user_dmg + "의 피해를 입었습니다!");
					user_now_hp = user_now_hp - user_dmg;
				} else {
					System.out.println("적의 공격을 막아냈습니다!");
				}
				
			}else {
				if(random>20) {
					System.out.println("공격을 회피했습니다!");
				}else {
					int user_dmg = monster_Atk - user_def - bonus_def;
					if (user_dmg > 0) {
						System.out.println(user_name + "이(가) " + user_dmg + "의 피해를 입었습니다!");
						user_now_hp = user_now_hp - user_dmg;
					} else {
						System.out.println("적의 공격을 막아냈습니다!");
					}
				}
				idamSkill=false;
			}
			sleep();
			if (user_now_hp <= 0) {
				System.out.println("사망했습니다...");
				user_win = false;
				break;
			}
			try {
			    Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}

		if (user_win && floorCheck) {
			sleep();
			System.out.println();
			System.out.println("전투에 승리했습니다.");
			// 전투 승리 이후에 경험치 얻고 레벨업하면 캐릭터 스텟 변동 시켜준 이후에 저장
			user_exp = user_exp + mon_exp;
			System.out.println("현재 경험치 : " + user_exp);
			user_gold = user_gold + mon_gold;
			int levelUp = user_exp / (user_level * 100);
			if (levelUp >= 1) {
				user_exp = user_exp - (user_level * 100);
				for (int i = 1; i <= levelUp; i++) {
					System.out.println("레벨이 올랐습니다!");
					user_level++;
					user_hp += 5;
					user_now_hp += 5;
					user_atk++;
					user_def++;
					System.out.println("현재 레벨 : " + user_level);
				}
				sleep();
			}

			// 배틀 dto에 실어서 보내야하는것
			// 아이디, 레벨, 현재체력, 공격력, 방어력, 골드
			BattleDTO btEndDto = new BattleDTO(id, user_hp, user_now_hp, user_level, user_exp, user_atk, user_def,
					user_gold);
			btDao.battleEndUpdate(btEndDto);
			System.out.println();
			System.out.println("다음 층으로 향하는 계단을 오릅니다.");
			sleep();
			return true;
		} else if(!user_win && floorCheck) {
			System.out.println();
			System.out.println("전투에 패배했습니다. 1층으로 돌아갑니다.");
			System.out.println();
			System.out.println("탑의 비석에 당신의 기록이 새겨졌습니다.");
			btDao.battleLoseUpdate(id, user_hp);
			Top_RankDTO TRdto = new Top_RankDTO(nick, user_name, floor);
			btDao.rankUpdate(TRdto);
			try {
			    Thread.sleep(1000); // 1초 지연
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}

			return false;
		} else {
			return false;
		}

	}

	public int random(int atk) {
		return atk + (int) (Math.random() * 10);
	}
	
	public void sleep() {
		try {
		    Thread.sleep(1000); // 1초 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
}
