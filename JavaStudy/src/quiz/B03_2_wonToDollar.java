package quiz;

import java.util.Scanner;

public class B03_2_wonToDollar {
	public static void main(String[] args) {
		double won, dollar;
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("���ϴ� ȯ�� �ݾ��� �Է��ϼ���. :");
		won = sc.nextDouble();
		dollar = won/(1122.80)*(1-0.0175);
		System.out.printf("%.2f�޷��Դϴ�.", dollar);		
	}
}
