package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class B14_4_GCD2 {	
	public static void main(String[] args) {
		//�� ���ڸ� �Է¹ް� �� ������ �ִ������� ���غ�����.
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		System.out.printf("ù ��° ���ڸ� �Է��� ������ : ");
		num1 = sc.nextInt();
		
		System.out.printf("�� ��° ���ڸ� �Է��� ������ : ");
		num2 = sc.nextInt();
		
		int gcd=1;
		
		ArrayList factor1 = new ArrayList();
		ArrayList factor2 = new ArrayList();
		
		for(int i=1; i<=num1; i++) {
			if(num1 % i == 0) {
				factor1.add(i);

			}
		
		}
		for(int j=1; j<=num2; j++) {
			if(num2 % j == 0) {
				factor2.add(j);

			}
		}

		for(int i=0; i<factor1.size(); i++) {
			for(int j=0; j<factor2.size(); j++) {
				if((int)factor1.get(i) == (int)factor2.get(j)) {
					gcd = (int) factor1.get(i);
				}
			}
		}
		System.out.printf("%d�� %d�� �ִ� ������� %d",num1, num2, gcd);
		
				
	}
}
