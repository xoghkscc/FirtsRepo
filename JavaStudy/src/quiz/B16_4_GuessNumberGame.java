package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_4_GuessNumberGame {
	public static void main(String[] args) {
		// 게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다.
		// 1. 플레이어는 8번의 시도를 할 수 있다.
		// 2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다.
		// 숫자와 위치가 다 맞을경우 -Strike
		// 숫자만 맞을 경우 -ball

		// ex. 정답이 3456일때 당신
		// >> 5634 ->4ball, >>3789 ->1Strike, >>3654 ->1Strike 3 ball
		// 빨리 맞출 수록 점수가 더 높도록 설정
		// 맞추고 나면 몇 번만에 맞췄는지 알려주기

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		boolean tf;
		int gameCnt, strikeCnt = 0, ballCnt = 0, userCnt = 0;
		String userNum = "";
		String gameNum = "";
		String exNum = "0123456789";
		int[] num = new int[4];

		for (int i = 0; i < 4; i++) {
			gameNum += exNum.charAt(ran.nextInt(10));
		}
		int num2=0;
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < 4; i++) {
//			sb.append((int)(Math.random()*10));
//		}
//		String answer = sb.toString();
//		System.out.printf("이번 정답 %s\n", answer);

		System.out.println(gameNum);

		for (int k = 0; k < 8; k++) {
			tf = true;
			strikeCnt = 0;
			ballCnt = 0;

			while (tf) {
				gameCnt=0;
				System.out.printf("4자리 숫자를 입력하세요 :");
				userNum = sc.next();
				
				if (userNum.length() == 4) {
					for (int j = 0; j < 4; j++) {
						if (userNum.charAt(j) >= '0' && userNum.charAt(j) <= '9') {
							gameCnt++;
						}
					}
					if (gameCnt == 4) {
						tf = false;
					} else {
						System.err.println("숫자만 입력해야 합니다");
					}
				} else {
					System.err.println("4자리만 입력해야 합니다.");
				}
			}

			System.out.println("입력한 숫자는 " + userNum + "입니다.");
			userCnt++;
			
			for (int i = 0; i < 4; i++) {
				if (userNum.charAt(i) == gameNum.charAt(i)) {
					num[i] = i;
				}
			}
			
			for (int j = 0; j < 4; j++) {
				if (userNum.charAt(j) == gameNum.charAt(j)) {
					strikeCnt++;
				} else {
					for (int i = 0; i < 4; i++) {
						if (userNum.charAt(j) == gameNum.charAt(i)) {
							for (int l = 0; l < 4; l++) {
								if(num[l] == i) {
									ballCnt--;
									break;
								}
							}
							ballCnt++;
							break;
						}
					}
				}
			}

			System.out.printf(" %d Strike %d ball\n", strikeCnt, ballCnt);
			for (int i = 0; i < 3; i++) {
				num[i]=-1;
			}//배열 초기화
			if (strikeCnt == 4) {
				break;
			}
			System.out.println("===============================");

		}

		if (strikeCnt == 4) {
			System.out.printf("%d회에 성공했습니다.", userCnt);
		} else {
			System.out.println("실패하였습니다.");
		}

	}
}
