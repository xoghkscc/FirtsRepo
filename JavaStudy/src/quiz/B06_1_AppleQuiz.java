package quiz;

import java.util.Scanner;

public class B06_1_AppleQuiz {
	public static void main(String[] args) {
//		사과를 10개씩 담을 수 있는 바구니가 있음
//		사용자가 구매하고 싶은 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한 바구니의 개수를
//		알려주는 프로그램
		
		Scanner sc = new Scanner(System.in);
		int appleCount;
		System.out.printf("구매하고 싶은 사과의 개수를 입력 : ");
		appleCount = sc.nextInt();
		
		B06_2_AppleQuiz2 aq = new B06_2_AppleQuiz2();
		aq.apple(appleCount);
	}	
}
