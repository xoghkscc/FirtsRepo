package quiz;

import java.util.Scanner;

public class B08_1_MonthToSeason {
	public static void main(String[] args) {
		//����ڷκ��� ���� �Է¹����� �ش��ϴ� ������ ����غ�����.

		Scanner sc = new Scanner(System.in);
		int month;

		System.out.printf("�� ������ �Է��ϼ��� :");

		month = sc.nextInt();
 		String season = null;

		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "�ܿ�";
			break;
		case 3:
		case 4:
		case 5:
			season = "��";
			break;
		case 6:
		case 7:
		case 8:
			season = "����";
			break;
		case 9:
		case 10:
		case 11:
			season = "����";
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
			System.exit(0);
		}
		System.out.println(season + "�Դϴ�.");
			
	}
}
