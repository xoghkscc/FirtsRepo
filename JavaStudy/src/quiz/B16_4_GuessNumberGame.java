package quiz;

import java.util.Random;
import java.util.Scanner;

public class B16_4_GuessNumberGame {
	public static void main(String[] args) {
		// ������ ���۵Ǹ� �������� 4�ڸ��� ���ڰ� �����ȴ�.
		// 1. �÷��̾�� 8���� �õ��� �� �� �ִ�.
		// 2. �� �õ����� 4�ڸ��� ���ڸ� �Է��ϸ� ������ ���� �˷��ش�.
		// ���ڿ� ��ġ�� �� ������� -Strike
		// ���ڸ� ���� ��� -ball

		// ex. ������ 3456�϶� ���
		// >> 5634 ->4ball, >>3789 ->1Strike, >>3654 ->1Strike 3 ball
		// ���� ���� ���� ������ �� ������ ����
		// ���߰� ���� �� ������ ������� �˷��ֱ�

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
//		System.out.printf("�̹� ���� %s\n", answer);

		System.out.println(gameNum);

		for (int k = 0; k < 8; k++) {
			tf = true;
			strikeCnt = 0;
			ballCnt = 0;

			while (tf) {
				gameCnt=0;
				System.out.printf("4�ڸ� ���ڸ� �Է��ϼ��� :");
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
						System.err.println("���ڸ� �Է��ؾ� �մϴ�");
					}
				} else {
					System.err.println("4�ڸ��� �Է��ؾ� �մϴ�.");
				}
			}

			System.out.println("�Է��� ���ڴ� " + userNum + "�Դϴ�.");
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
			}//�迭 �ʱ�ȭ
			if (strikeCnt == 4) {
				break;
			}
			System.out.println("===============================");

		}

		if (strikeCnt == 4) {
			System.out.printf("%dȸ�� �����߽��ϴ�.", userCnt);
		} else {
			System.out.println("�����Ͽ����ϴ�.");
		}

	}
}
