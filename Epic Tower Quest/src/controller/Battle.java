package controller;

import java.util.Scanner;

import model.BattleDAO;
import model.BattleDTO;
import model.TopDTO;
import model.UserCharDTO;
import model.UserDTO;


public class Battle {
	
	public void floorCheck(String id) {
		int floor = 1;
		BattleDAO btDao = new BattleDAO();
		
		while(true) {
			UserCharDTO userDto = btDao.userCharDto(id) ;
			boolean bt = battle(userDto, floor);
			floor++;
			if (!bt) {
				break;
			}
		}
		
	}
	
	
	public boolean battle(UserCharDTO userDto, int floor) {
		
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
		
		TopDTO topDto =   btDao.topMon(floor);
		
		String id = userDto.getID();
		String user_name = userDto.getCHAR_NAME();
		String mon_name = topDto.getMON_NAME();
		int user_atk = userDto.getUSER_ATK();
		int user_def = userDto.getUSER_DEF();
		int user_now_hp = userDto.getUSER_HP();
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
		
		boolean user_win = true;
		System.out.println("현재 층 : "+floor+"층");
		System.out.println("전투 시작!");
		while (true) {
			System.out.println("["+mon_name+"] 체력 : "+mon_now_hp+"/"+mon_hp);
			System.out.println("당신의 체력 : "+user_now_hp+"/"+user_hp);
			System.out.println("당신의 공격력 : "+user_atk+" / 당신의 방어력 : "+user_def);
			int bonus_def = 0;
			int bonus_atk = 0;
			boolean bonus_crt = false;
			boolean isCrt = false;
			while(true) {
				System.out.println("[1] 방어 태세 [2] 공격 태세");
				int check = sc.nextInt();
				if(check == 1) {
					bonus_def=10;
					System.out.println("방어를 굳힙니다. 추가 방어력을 얻습니다.");
					break;
				}else {
					bonus_atk=10;
					bonus_crt = true;
					System.out.println("공격 태세를 취합니다. 추가 공격력과 치명타 확률을 얻습니다");
					break;
				}
				
			}
			
			System.out.println(user_name + "의 공격!");
			int basicAtk = random(user_atk);
			int mon_dmg = 0;
			if(bonus_crt) {
				if(50<(int)(Math.random()*100)) {
					isCrt = true;
					mon_dmg = (int)((basicAtk+bonus_atk)*1.2)-mon_def;
				}else {
					
					mon_dmg = basicAtk+bonus_atk-mon_def;
				}
			}else {
				mon_dmg = basicAtk+bonus_atk-mon_def;
			}
			if(mon_dmg>0) {	
				if(isCrt) {
					System.out.println("치명타!");
				}
				System.out.println(mon_name+"이(가) "+mon_dmg+"의 피해를 입었습니다!");
				mon_now_hp = mon_now_hp-mon_dmg;
			}else {
				System.out.println("적이 공격을 방어했습니다!");
			}
			
			
			if(mon_now_hp<=0) {
				System.out.println(mon_name+"을(를) 처치했습니다!");
				user_win=true;
				break;
			}
			System.out.println(mon_name+"의 공격!");
			int monster_Atk = random(mon_atk);
			int user_dmg = monster_Atk-user_def-bonus_def;
			if(user_dmg>0) {				
				System.out.println(user_name+"이(가) "+user_dmg+"의 피해를 입었습니다!");
				user_now_hp = user_now_hp-user_dmg;
			}else {
				System.out.println("적의 공격을 막아냈습니다!");
			}
			
			if(user_now_hp<=0) {
				System.out.println("사망했습니다...");
				user_win=false;
				break;
			}	
		}
		
		if(user_win) {
			System.out.println("전투에 승리했습니다.");
			//전투 승리 이후에 경험치 얻고 레벨업하면 캐릭터 스텟 변동 시켜준 이후에 저장
			user_exp=user_exp+mon_exp;
			user_gold = user_gold+mon_gold;
			int levelUp=user_exp/(user_level*100);
			if(levelUp>=1) {
				user_exp=user_exp-(user_level*100);
				for (int i = 1; i <= levelUp; i++) {					
					user_level++;
					user_atk++;
					user_def++;
				}
			}
			
			// 배틀 dto에 실어서 보내야하는것
			// 아이디, 레벨, 현재체력, 공격력, 방어력, 골드
			BattleDTO btEndDto = new BattleDTO(id, user_now_hp, user_atk, user_def, user_gold);
			System.out.println(btEndDto.toString());
			btDao.battleEndUpdate(btEndDto);
			
			return true;
			
		}else {
			System.out.println("전투에 패배했습니다. 랭킹을 등록합니다");
			
			return false;
		}

	}

	public int random(int atk) {
		return atk + (int) (Math.random() * 10);
	}
}
