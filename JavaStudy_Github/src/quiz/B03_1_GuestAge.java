package quiz;

import java.util.Scanner;

public class B03_1_GuestAge {
	public static void main(String[] args) {
		int age;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("�¾ �⵵�� �Է��ϼ��� : ");
		int birth = sc.nextInt();
		
		System.out.printf("���� �⵵�� �Է��ϼ��� : ");
		int year = sc.nextInt();
		
		age = year-birth + 1;
		
		System.out.printf("����� ���̴� %d���Դϴ�.", age);
		
	}
}
