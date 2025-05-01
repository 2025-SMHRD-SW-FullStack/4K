package view;

import java.util.Scanner;

import controller.Lobby;
import model.UserDAO;
import model.UserDTO;

public class Main {

	public static void main(String[] args) {
		System.out.println("==== Epic Tower Quest 프로그램 ====");
		// 타이틀이랑 아스키코드 출력
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("[1]회원가입 [2]로그인 [3]회원탈퇴 [4]전체회원 조회 [5]회원정보 수정 >> ");
			int number = sc.nextInt();
			
			if(number == 1) {
				System.out.println("==== 회원가입 기능 ====");
				
				System.out.print("ID를 입력해 주세요 >> ");
				String user_ID = sc.next();
				
				System.out.print("PW를 입력해 주세요 >> ");
				String user_PW = sc.next();
				
				System.out.print("NICKNAME을 입력해 주세요 >> ");
				String NICKNAME = sc.next();
				
				UserDAO dao = new UserDAO();
				int joinResult = dao.join(user_ID, user_PW, NICKNAME);
				if(joinResult > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패!");
				}
			} else if (number == 2) {
				System.out.println("==== 로그인 기능 ====");
				
				System.out.print("로그인할 ID를 입력하세요 : ");
				String user_ID = sc.next();
				
				System.out.print("로그인할 PW를 입력하세요 : ");
				String user_PW = sc.next();
				
				UserDAO dao = new UserDAO();
				
				UserDTO dto = dao.login(user_ID, user_PW);
				
				if(dto != null) {
					System.out.println(dto.getNICKNAME() + "님 환영합니다!");
					Lobby game = new Lobby(user_ID);
					break;
				} else {
					System.err.println("로그인에 실패했습니다.");
				}
			} else if (number == 3) {
                System.out.println("==== 회원탈퇴 ====");

                System.out.print("삭제할 ID를 입력하세요 : ");
                String user_ID = sc.next(); 
                
                System.out.print("삭제할 PW를 입력하세요 : ");
                String user_PW = sc.next(); // Use nextLine()
                
                // 데이터 베이스에 접근해서 Delete문 실행하기!
                
                // DAO -> 데이터베이스 접근 기능을 가진 객체 
                
                UserDAO dao = new UserDAO();
                
                int result = dao.deleteMember(user_ID, user_PW);

                if (result > 0) {
                    System.out.println("회원탈퇴 성공");
                } else {
                    System.out.println("회원탈퇴 실패");
                }
		}
		
		
		}
	}

}

