package quiz;

import java.util.Scanner;

public class B15_2_Count369 {
	public static void main(String[] args) {
		//사용자로부터 정수를 하나 입력받고 해당 숫자까지 369게임이 진행된다면
		//박수를 총 몇 번 쳐야하는지 세어보세요.
		Scanner sc = new Scanner(System.in);
		int userNum = 0;
		System.out.printf("숫자를 입력하세요 : ");
		userNum = sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i<=userNum; i++) {
			String userNum2 = Integer.toString(i);
				for (int j = 0; j < userNum2.length(); j++) {
//					System.out.println((userNum3.charAt(j)));
					if(((int)(userNum2.charAt(j)) % 3 == 0) && ((userNum2.charAt(j)) != '0')) {
						System.out.println(i +"짝 ");
						sum++;
					}
				}
			}
		System.out.println("\n" + sum);
		
	}
}
