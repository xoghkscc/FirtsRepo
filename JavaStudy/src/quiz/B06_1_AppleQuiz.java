package quiz;

import java.util.Scanner;

public class B06_1_AppleQuiz {
	public static void main(String[] args) {
//		����� 10���� ���� �� �ִ� �ٱ��ϰ� ����
//		����ڰ� �����ϰ� ���� ����� ������ �Է��ϸ� ����� ��� ��� ���� �ʿ��� �ٱ����� ������
//		�˷��ִ� ���α׷�
		
		Scanner sc = new Scanner(System.in);
		int appleCount;
		System.out.printf("�����ϰ� ���� ����� ������ �Է� : ");
		appleCount = sc.nextInt();
		
		B06_2_AppleQuiz2 aq = new B06_2_AppleQuiz2();
		aq.apple(appleCount);
	}	
}
