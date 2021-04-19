package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C13_InputRightThing {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ����ڷκ��� ���ڸ� ����� �Է¹����� ���� ��� �Է¹޴� ���α׷��� ����� ������.
		// (�߸��� ���� �ԷµǾ ����������� �ʰ� �ùٸ� ���� �ԷµǸ� ��� �� ���α׷� ����
		int a = inputInt("���� > ");

		System.out.println("input �Լ��� �Է¹��� ��: " + a);
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
