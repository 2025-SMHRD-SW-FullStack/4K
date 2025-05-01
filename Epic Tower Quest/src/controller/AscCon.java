package controller;

import ascill.ascController;

public class AscCon {
	public void img(int floor) {
		ascController img = new ascController();
		switch (floor) {
		case 1:
			img.Slime();
			break;
		case 2:
			img.goblin();
			break;
		case 3:
			img.Wolf();
			break;
		case 4:
			img.Oak();
			break;
		case 6:
			img.Skeleton();
			break;
		case 7:
			img.Zombi();
			break;
		case 8:
			img.Wizard();
			break;
		case 9:
			img.WolfMan();
			break;
		case 11:
			img.Giant();
			break;
		case 12:
			img.Vampire();
			break;
		case 13:
			img.Mino();
			break;
		case 14:
			img.Knight();
			break;
		case 16:
			img.Shadow();
			break;
		case 17:
			img.Wolf_Elemental();
			break;
		case 18:
			img.Fire_Elemental();
			break;
		case 19:
			img.ice_Elemental();
			break;
		case 20 :
			img.Boss();
			break;
			
		default:
			// 조건식의 결과 값이 위의 어떤 값에도 해당하지 않을 때 실행되는 코드
		}
	}
}
