package quiz;

import java.util.Scanner;

public class B14_2_Prime {
	public static void main(String[] args) {
		/*
		����ڷκ��� ���ڸ� �Է¹����� 1���� �Է��� ���� ���̿� �����ϴ�
		�Ҽ��� ��� ����غ�����. 
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("���ڸ� �Է��� ������.");
		int userNum = sc.nextInt();
		int count = 0;
		for (int i = 2; i <= userNum; i++) {
			for (int j = 2; j < i; j++) {
				float k = j;

				// if (i % k != 0)
				if (i / k - Math.floor(i / k) != 0) {
					count++;
				}
			}
			if (count == i - 2) {
				System.out.println(i);
			}
			count = 0;
		}
	}

}
