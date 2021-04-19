package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C01_1_FunctionQuiz {
	public static void main(String[] args) {
		//다음의 함수를 정의하고 올바르게 동작하는지 테스트 해보세요.
		//1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
		//2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
		//3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
		//4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수 
		//5. 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
		//6. 숫자를 전달하면 해당 숫자의 팩토리얼 결과를 반환하는 함수
		//factorial = 5! = 5*4*3*2*1
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("몇 번 문제를 해 볼까? :");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.print("문자를 입력하세요 : ");
			char alpha = sc.next().charAt(0);
			boolean tf = alpha(alpha);
			System.out.println(alpha + "는 " + tf+"입니다.");
			break;
		case 2:
			System.out.print("숫자를 입력하세요 : ");
			int userNum = sc.nextInt();
			boolean tf2 = multiples(userNum);
			System.out.println(userNum + "은 3의 배수가 "+ tf2 + "입니다.");
			break;
		case 3:
			System.out.print("숫자를 입력하세요 : ");
			int userNum2 = sc.nextInt();
			String sniffling = sniffling(userNum2);
			System.out.println(userNum2 + "는 "+ sniffling + "입니다.");
			break;
		case 4:
			System.out.print("숫자를 입력하세요 : ");
			int userNum3 = sc.nextInt();
			ArrayList list = new ArrayList();
			list = measure(userNum3);
			System.out.println(list);
			int ArraySize=0;
			for (int i = 1; i <= userNum3; i++) {
				if(userNum3 % i == 0) {
					ArraySize++;
				}
			}
			int [] measure2 = new int[ArraySize];
			measure2=measure2(userNum3);
				System.out.print(Arrays.toString(measure2));
				
			break;
		case 5:
			System.out.print("숫자를 입력하세요 : ");
			int userNum4 = sc.nextInt();
			boolean tf3 = prime(userNum4);
			System.out.println(userNum4 + "는 소수가 "+ tf3 + "입니다.");
			break;
		case 6:
			System.out.print("숫자를 입력하세요 : ");
			int userNum5 = sc.nextInt();
			int userFactorila = factorial(userNum5);
			System.out.println(userNum5 + "의 팩토리얼은 "+ userFactorila + "입니다.");
			break;

		default:
			System.out.println("입력할 숫자는 1~6입니다.");
			break;
		}
	}
	//1번 메서드
	public static boolean alpha(char alpha) {
		
		if((alpha>='a' && alpha<='z') || (alpha>='A' && alpha<='Z')) {
			return true;
		}else {
			return false;
		}
	}
	
	//2번 메서드
	public static boolean multiples(int userNum) {
		if(userNum % 3 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//3번 메서드
	public static String sniffling(int userNum2) {
		if(userNum2 % 2 == 0) {
			return "짝수";
		}else {
			return "홀수";
		}
	}
	
	//4번 메서드
	public static ArrayList measure(int userNum3) {
		ArrayList list = new ArrayList();
		for (int i = 1; i <= userNum3; i++) {
			if( userNum3 % i == 0) {
				list.add(i);
			}
		}
		return list;
		
		
		
	}
	
	//4-1번 메서드(배열로 하기)
	public static int[] measure2(int userNum3) {
		int ArraySize=0;
		for (int i = 1; i <= userNum3; i++) {
			if(userNum3 % i == 0) {
				ArraySize++;
			}
		}
		int[] measure = new int[ArraySize];
		int j = 0;
		for (int i = 1; i <= userNum3; i++) {
			if(userNum3 % i == 0) {
				measure[j] = i;
				j++;
			}
		}
		return measure;
	}
	
	//5번 메서드
	public static boolean prime(int userNum4) {
		int cnt=0;
		for (int i = 1; i <= userNum4; i++) {
			if(userNum4 % i ==0) {
				cnt++;
			}
		}

		if (cnt == 2) {
			return true;
		}
		return false;

	}
	
	//6번 메서드
	public static int factorial(int userNum5) {
		int factorial = 1;
		for (int i = 1; i <= userNum5; i++) {
			factorial *= i; 
		}
		return factorial;
	}
}
