package quiz;

import java.util.Scanner;

public class B03_3_celToFahr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double cel, fahr;
		
		System.out.printf("���� �µ��� �Է��ϼ��� : ");
		cel = sc.nextDouble();
		fahr = cel*1.8+32;
		
		System.out.printf("���� ���� �µ��� %.1f�̰� ȭ�� �µ��� %.1f�Դϴ�.",cel, fahr);
	}
}
