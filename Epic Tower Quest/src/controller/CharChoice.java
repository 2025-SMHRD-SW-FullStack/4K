package controller;

import java.util.Scanner;

import model.CharChoiceDAO;
import model.UserCharDTO;

public class CharChoice {
	Scanner sc = new Scanner(System.in);

	public void CharChoice(String id) {
		UserCharDTO dto = new UserCharDTO();
		CharChoiceDAO dao = new CharChoiceDAO();
		UserCharDTO charsty = new UserCharDTO();
		boolean stop = false;

		while(!stop) {
			System.out.println("=================  캐릭터 선택  =================");
			System.out.println("캐릭터를 선택하시면 정보를 보실 수 있습니다.");
			System.out.println("[1]정시우 [2]김하윤 [3]서이담 [4]exit >> ");
			int input = sc.nextInt();
			
			switch (input) {
			case 1: {
				System.out.println("=========================================");
				dto.JeongInfo("info");
				System.out.println("=========================================");
				System.out.println("이 캐릭터로 플레이 하시겠습니까?");
				System.out.println("[ Y / N ]");
				String choice = sc.next();
				
				if (choice.equals("Y") || choice.equals("y")) {
					//star_char 데이터셋에서 정시우를 불러와서 user_char에 집어넣기
					dao.charChoice(id, "정시우");
					charsty.JeongInfo("pr");
					stop = true;
				} 
				
				break;
			}
			case 2: {
				System.out.println("=========================================");
				dto.KimInfo("info");
				System.out.println("=========================================");
				System.out.println("이 캐릭터로 플레이 하시겠습니까?");
				System.out.println("[ Y / N ]");
				String choice = sc.next();
				
				if (choice.equals("Y") || choice.equals("y")) {
					dao.charChoice(id, "김하윤");
					charsty.KimInfo("pr");
					stop = true;
				}
				break;
				
			}
			case 3: {
				System.out.println("=========================================");
				dto.SeoInfo("info");
				System.out.println("=========================================");
				System.out.println("이 캐릭터로 플레이 하시겠습니까?");
				System.out.println("[ Y / N ]");
				String choice = sc.next();
				
				if (choice.equals("Y") || choice.equals("y")) {
					dao.charChoice(id, "서이담");
					charsty.SeoInfo("pr");
					stop = true;
				}
				break;
			}
			case 4: {
				stop = true;
			}
			
			
			}
			
		}
	}
}
