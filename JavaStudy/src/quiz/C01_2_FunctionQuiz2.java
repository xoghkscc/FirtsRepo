package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C01_2_FunctionQuiz2 {
	public static void main(String[] args) {
		//1. 최대값을 매개변수로 전달 받으면 0부터 최대값 미만의 모든 값을 포함하는 int 배열을 생성하여 반환하는
		//range 함수를 만들어보세요.
		//2. 최소값과 최대값을 매개변수로 받으면, 그 사이에 존재하는 모든 값을 포함하는
		//int배열을 생성하여 반환하는 range 함수를 만들어 보세요.(최소값 이상, 최대값 미만)
		//3. 최소값과 최대값과 증가값을 매개변수로 받으면 최소값에서 시작하여 최대값까지 증가값만큼 증가하는
		//int 배열을 생성하여 반환하는 range 함수를 만들어보세요.(최소값 이상, 최대값 미만)
		//ex range(50, 56, 5)의 결과 -->[50, 55]
		//ex range(50, 55, 5)의 결과 -->[50]
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 :");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요 :");
		int num2 = sc.nextInt();
		int maxNum = Math.max(num1, num2);
		int minNum = Math.min(num1, num2);
		System.out.printf("최대값 : %d, 최소값 : %d",maxNum, minNum);
		System.out.println();
		
		
		boolean tf = true;
		while(tf) {
			System.out.println();
			System.out.print("몇 번 문제를 해 볼까? :(그만하고 싶으면 4번을 입력) ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				int[] numArray = range(maxNum);
				System.out.println(Arrays.toString(numArray));
				break;
			case 2:
				int[] numArray2 = range(maxNum, minNum);
				System.out.println(Arrays.toString(numArray2));
				break;
			case 3:
				System.out.print("증가값을 입력 하세요 : ");
				int plusValue = sc.nextInt();
				int[] numArray3 = range(maxNum, minNum, plusValue);
				System.out.println(Arrays.toString(numArray3));
				break;
	
			case 4:
				tf = false;
				System.out.println("끝~");
				break;
				
			default:
				System.out.println("숫자 1~4만 입력하세요.");
				break;
			}
		}
		
	}
	
	//1번 메서드
	public static int[] range(int maxNum) {
		int[] numArray = new int[maxNum];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i]=i;
		}
		return numArray;
	}
	
	//2번 메서드
	public static int[] range(int maxNum, int minNum) {
		int[] numArray = new int[maxNum-minNum];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = minNum+i;
		}
		return numArray;
	}
	
	//3번 메서드
	public static int[] range(int maxNum, int minNum, int plusValue) {
		int cnt=0;
		for (int i = 0; i < maxNum; i++) {
			if(minNum+plusValue*i<maxNum) {
				cnt++;
			}
		}
		
		int[] numArray = new int[cnt];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = minNum + i*plusValue;
		}
		return numArray;
	}
	
	
}
