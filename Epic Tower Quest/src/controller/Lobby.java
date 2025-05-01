package controller;

import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import model.UserCharDAO;
import model.UserCharDTO;
import model.UserDAO;
import model.UserDTO;

public class Lobby {
	Scanner sc = new Scanner(System.in);
	UserCharDAO dao = new UserCharDAO();

	public Lobby(UserDTO user) {

		UserCharDTO userChar = dao.getUserCharInfo(user.getID());

		// mp3
		MP3Player mp3 = new MP3Player();
		
		// 상대경로
//		mp3.play("./로비.mp3");
		
		
		// 절대경로
		mp3.play("src/music/로비.mp3");
		

		if (userChar == null) {
			CharChoice charchoice = new CharChoice();
			charchoice.CharChoice(user.getID());

		}

		// 로비의 아스키 아트 출력 해주면 좋을것 같음
		System.out.println("당신은 탑의 초입에 서 있습니다.");
		System.out.println("다른 층들과 달리 이곳은 따스한 기운이 서려있습니다. ");
		System.out.println();

		while (true) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("================================================");
			System.out.println("[1]캐릭터 정보 확인 [2]강화 [3]탑을 오른다 [4]랭킹 확인 [5]탑을 나간다");

			int input = sc.nextInt();

			if (input == 1) {
				// 캐릭터 정보 출력 이름, 체력, 보유 골드, 공격력, 방어력, 무기 강화 정도, 방어구 강화 정도
				userChar = dao.getUserCharInfo(user.getID());
				System.out.println("======= 캐릭터 정보 =======");
				System.out.println(userChar.getCHAR_NAME());
				System.out.print("LV. " + userChar.getLEV() + "\t");
				System.out.println("\tEXP. " + userChar.getEXP());
				System.out.println();
				System.out.println("ATK." + userChar.getUSER_ATK());
				System.out.println("Weapon" + " + " + userChar.getWEAPON() + "강");
				System.out.println("DEF. " + userChar.getUSER_DEF());
				System.out.println("Armor" + " + " + userChar.getARMOR() + "강");
				System.out.println();
				System.out.println("보유 골드 : " + userChar.getGOLD_HELD() + " Gold");
				System.out.println("=========================");

				System.out.println();
			} else if (input == 2) {
				// 아스키 코드
				System.out.println("로비 한켠에 위치한 자그마한 대장간에 들렸습니다. ");
				System.out.println("한 드워프가 당신을 반깁니다. ");
				System.out.println("\"어서오시게나! 오랜만의 방문객이군! 무슨일로 왔는가?\"");
				Upgrade upgrade = new Upgrade();
				upgrade.userCmd(user.getID());
			} else if (input == 3) {

				// 아스키코드
				System.out.println("당신은 안락한 로비를 떠나 타워를 오르기로 하였습니다. ");
				System.out.println("이제 뒤로 돌아갈 수 없습니다. ");
//				System.out.println(" 당신에게 여신의 가호가 있기를 ");
				Battle battle = new Battle();
				boolean floor = battle.floorCheck(user.getID(), user.getNICKNAME());

				if (floor) {

					System.out.println("\"너는 아직 끝나지 않았다.\"");
					System.out.println("당신은 다시 눈을 뜨게되었습니다.");
//				System.out.println("흐릿한 기억이 남았습니다.");
					System.out.println("당신은 탑의 초입에 서 있습니다.");
				} else {
					break;
				}

			} else if (input == 4) {
				Rank rk = new Rank();
				System.out.println("닉네임\t캐릭터\t최대층");
				rk.showRank();
			} else if (input == 5) {
				System.out.println("정말로 탑을 나가시겠습니까?");
				System.out.println("[1]탑을 나간다 [2]다시 로비로 돌아간다 ");
				input = sc.nextInt();
				if (input == 1) {
					System.out.println("안녕히 가십시오.");
					break;
				} else if (input == 2) {
					System.out.println("당신은 다시 로비로 돌아가기로 결정하였습니다.");
				}
			}
		}
	}
}
