package quiz;

import java.util.Scanner;

public class B14_2_Prime {
	public static void main(String[] args) {
		/*
		사용자로부터 숫자를 입력받으면 1부터 입력한 숫자 사이에 존재하는
		소수를 모두 출력해보세요. 
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("숫자를 입력해 보세요.");
		int userNum = sc.nextInt();
		int count = 0;
		for (int i = 2; i <= userNum; i++) {
			for (int j = 2; j < i; j++) {
				float k = j;

				// if (i % k != 0)
				if (i / k - Math.floor(i / k) != 0) {
					count++;
				}
			}
			if (count == i - 2) {
				System.out.println(i);
			}
			count = 0;
		}
	}

}
