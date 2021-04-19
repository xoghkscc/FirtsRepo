package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C13_InputRightThing {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 사용자로부터 숫자를 제대로 입력받을때 까지 계속 입력받는 프로그램을 만들어 보세요.
		// (잘못된 값이 입력되어도 강제종료되지 않고 올바른 값이 입력되면 출력 후 프로그램 종료
		int a = inputInt("숫자 > ");

		System.out.println("input 함수로 입력받은 값: " + a);
	}

	public static int inputInt(String message) {
		int num;
		while (true) {
			try {
				System.out.print(message);
				num = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		}

		return num;
	}

}
