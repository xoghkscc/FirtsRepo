package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_3_31Game {
	public static void main(String[] args) {
		//31 게임을 만들어 보세요
		// 1. 컴퓨터와 사람이 번갈아가면서 숫자를 선택해야 한다.(1, 2, 3 밖에 선택할 수 없음)
		// 2. 컴퓨터는 랜덤으로 숫자를 선택한다.
		//3. 선공은 랜덤으로 결정
		//4. 마지막에 31 이상의 숫자를 만드 수 밖에 없는 플레이어가 패배
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int userNum, comNum=0;
		int turn;
		int gameNum = 0;
		if(ran.nextBoolean()) {
			System.out.println("플레이어 선공");
			turn = 0;
		}else {
			System.out.println("컴퓨터 선공");
			turn = 1;
		}
				
		while(true) {
			System.out.println("\n현재 숫자는 : "+ gameNum);
			if(turn ==0) {
				while(true) {
					System.out.print("1~3 중 숫자를 택해주세요 :");
					userNum = sc.nextInt();
					if(userNum>= 1 && userNum <=3 ) {
						gameNum += userNum;
						turn = 1;
						break;
					}else {
						System.err.println("숫자는 1~3까지만 입력해야 합니다.");
					}
				}
			}else {
				switch (gameNum) {
				case 27:
					comNum = 3;
					break;
				case 28:
					comNum = 2;
					break;
				case 29:
					comNum = 1;
					break;

				default:
					comNum = ran.nextInt(3)+1;
					break;
				}	
				System.out.println("컴퓨터가 선택한 숫자는 "+ comNum +"입니다");
				gameNum += comNum;
				turn = 0;
			}
			
			if(gameNum >=31) {
				System.out.println("\n현재 숫자는 : "+ gameNum);
				if(turn == 1) {
					System.out.println("플레이어의 패배");
				}else if(turn == 0) {
					System.out.println("컴퓨터의 패배");
				}
				break;
			}
		}
		
	}
}