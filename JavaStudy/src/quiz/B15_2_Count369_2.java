package quiz;

import java.util.Scanner;

public class B15_2_Count369_2 {
	public static void main(String[] args) { 
		//����ڷκ��� ������ �ϳ� �Է¹ް� �ش� ���ڱ��� 369������ ����ȴٸ�
		//�ڼ��� �� �� �� �ľ��ϴ��� �������.
		Scanner sc = new Scanner(System.in);
		int userNum = 0;
		System.out.printf("���ڸ� �Է��ϼ��� : ");
		userNum = sc.nextInt();
		int cnt = 0;
		int digits = 1; 
		
		for (int i = 1; i < userNum; i++) {
			if(userNum>=Math.pow(10, i-1) && userNum<Math.pow(10, i)) {
				digits = i; //����ڰ� �Է��� ���� �ڸ��� ex. 369�Է� -->digits = 3
				break;
			}
		}
		
		for(int i = 1; i <= userNum; i++) {
			System.out.printf(i + ":");
			double num0 = i; //i�� 364�� ��쿡 ���ؼ� ���ø� ���� num0��  364�� ��
			for (int j = 0; j < digits; j++) {	
				double num1 = Math.floor(num0 / Math.pow(10, digits-j-1));	//1-1. num0 =364��� num1�� 3�� ����, 2-1. num0�� 64�̸� j�� 1�̹Ƿ� 10�� ���� �� num1�� 6�� ����
				//�� �ڸ� ���� ���� ����� digits(�ڸ���)�� 10�� �ŵ�������ŭ ���ؼ� ������ ��(�̶� j�� Ŀ���Ƿ� ó���̸� 100�� ������ �� ������ 10 �� ������ 1�� ����)
				double num2 = num0 % Math.pow(10, digits-j-1);	//1-2. num2�� 64 ���� 2-2. num2�� 4����
				if((num1 % 3 == 0) && (num1 != 0)) { //1-3 num1�� 3�̹Ƿ� ���� 2-3 num1�� 6�̹Ƿ� ����
					System.out.printf("¦ "); 
					cnt++;
				}
				num0 = num2; //1-4. 64�� num0�� ���� 2-4 4�� num0�� ���� *�ݺ�!
			}
			System.out.println();
			
		}
		System.out.println("�ڼ� ģ Ƚ���� "+cnt);
	}		
}
