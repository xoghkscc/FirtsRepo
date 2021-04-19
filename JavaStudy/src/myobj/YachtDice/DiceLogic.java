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
			System.out.printf("%d��° �÷��̾� �����Դϴ�.(%d��)\n", order, turn);
			System.out.printf("1. �ֻ��� ��ü ������, 2. �ֻ��� �Ϻ� ������, 3. �ֻ��� ����>>");
			num = sc.nextInt();
//			}else {
//				System.out.printf("5���� ������ �����Դϴ�.");
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
					System.out.print("��� �ֻ����� �ٽ� ���� �ǰ���?(�Է� ���ϸ� 0�� �Է�)");
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
				System.out.println("�ֻ��� ��ȣ "+Arrays.toString(dice)+"�� �����Ͽ����ϴ�." );
				yr = new YachtRule(dice);
				System.out.println(yr.gameStart()+"���� ������ϴ�.");
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
