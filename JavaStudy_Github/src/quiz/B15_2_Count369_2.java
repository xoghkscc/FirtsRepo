package quiz;

import java.util.Scanner;

public class B15_2_Count369_2 {
	public static void main(String[] args) { 
		//사용자로부터 정수를 하나 입력받고 해당 숫자까지 369게임이 진행된다면
		//박수를 총 몇 번 쳐야하는지 세어보세요.
		Scanner sc = new Scanner(System.in);
		int userNum = 0;
		System.out.printf("숫자를 입력하세요 : ");
		userNum = sc.nextInt();
		int cnt = 0;
		int digits = 1; 
		
		for (int i = 1; i < userNum; i++) {
			if(userNum>=Math.pow(10, i-1) && userNum<Math.pow(10, i)) {
				digits = i; //사용자가 입력한 수의 자리수 ex. 369입력 -->digits = 3
				break;
			}
		}
		
		for(int i = 1; i <= userNum; i++) {
			System.out.printf(i + ":");
			double num0 = i; //i가 364인 경우에 대해서 예시를 들어보자 num0는  364가 됨
			for (int j = 0; j < digits; j++) {	
				double num1 = Math.floor(num0 / Math.pow(10, digits-j-1));	//1-1. num0 =364라면 num1에 3을 추출, 2-1. num0이 64이며 j는 1이므로 10을 나눔 즉 num1에 6을 추출
				//각 자리 숫자 추출 방법은 digits(자리수)을 10의 거듭제곱만큼 곱해서 나누면 됨(이때 j는 커지므로 처음이면 100을 나누고 그 다음엔 10 그 다음엔 1을 나눔)
				double num2 = num0 % Math.pow(10, digits-j-1);	//1-2. num2에 64 추출 2-2. num2에 4추출
				if((num1 % 3 == 0) && (num1 != 0)) { //1-3 num1이 3이므로 만족 2-3 num1이 6이므로 만족
					System.out.printf("짝 "); 
					cnt++;
				}
				num0 = num2; //1-4. 64를 num0에 대입 2-4 4를 num0에 대입 *반복!
			}
			System.out.println();
			
		}
		System.out.println("박수 친 횟수는 "+cnt);
	}		
}
