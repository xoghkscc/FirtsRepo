package myobj.YachtDice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiceLogic {
	YachtRule yr;
	Random ran;
	int peopleNum;
	int[] player = new int[peopleNum];
	int[] dice = new int[5];
	int order=1;
	int turn = 1;
	Scanner sc = new Scanner(System.in);
	int num;
	
	public DiceLogic(int peopleNum) {
		this.peopleNum=peopleNum;
		
	}
	
	public void game(){
		boolean tf = true;
		while(tf) {
//			if(turn<=4) {
			System.out.printf("%d번째 플레이어 차례입니다.(%d턴)\n", order, turn);
			System.out.printf("1. 주사위 전체 굴리기, 2. 주사위 일부 굴리기, 3. 주사위 제출>>");
			num = sc.nextInt();
//			}else {
//				System.out.printf("5턴은 무조건 제출입니다.");
//				num = 3;
//			}
			switch (num) {
			case 1:
				for (int i = 0; i < 5; i++) {
					dice[i] = randomNum();
				}
				System.out.println(Arrays.toString(dice));
				turn++;
				break;
			case 2:
				while(true) {
					System.out.print("몇번 주사위를 다시 굴릴 건가요?(입력 다하면 0을 입력)");
					int choose = sc.nextInt();
					if(choose == 0) {
						break;
					}
					dice[choose-1] =  randomNum();
				}
				System.out.println(Arrays.toString(dice));
				turn++;
				break;
			case 3:
				System.out.println("주사위 번호 "+Arrays.toString(dice)+"를 제출하였습니다." );
				yr = new YachtRule(dice);
				System.out.println(yr.gameStart()+"점을 얻었습니다.");
				tf = false;
				break;
				
			default:
				break;
			}
		}
		
	}
	
	
	
	public int randomNum() {
		ran = new Random();
		int num = ran.nextInt(6)+1;
		return num;
	}
	
}
