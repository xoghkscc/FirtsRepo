package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C7_2_gameMode extends C07_2_barrel {
	Scanner sc = new Scanner(System.in);
	public C7_2_gameMode(int size) {
		super(size);
	}
	
	public void gameMode1() {//컴퓨터와의 싸움
		int turn = (int) (Math.random()*2+1);
		boolean tf =true;
		while(tf) {
			System.out.println("넣은 구멍의 번호는 "+Arrays.toString(try1)+"입니다.");
			if(turn == 1) {
				System.out.printf("사용자의 턴입니다 번호를 입력하세요 : ");
				tf = doubleCheck(sc.nextInt());
				turn = 2;
				
			}else {
				int comNum = comRandom();
				System.out.printf("컴퓨터의 턴입니다\n");
				System.out.println("컴퓨터가 넣은 구멍의 번호는 " + comNum+"입니다.");
				tf = judgment(comNum);
				turn = 1;
			}
		}
	}
	
	public void gameMode2() {//나와의 싸움
		boolean tf =true;
		while(tf) {
			System.out.println("넣은 구멍의 번호는 "+Arrays.toString(try1)+"입니다.");
				System.out.printf("사용자의 턴입니다 번호를 입력하세요 : ");
				tf = doubleCheck(sc.nextInt());
				
			
		}
		
	}
}
