package quiz;

import java.util.Scanner;

public class B15_2_Count369 {
	public static void main(String[] args) {
		//����ڷκ��� ������ �ϳ� �Է¹ް� �ش� ���ڱ��� 369������ ����ȴٸ�
		//�ڼ��� �� �� �� �ľ��ϴ��� �������.
		Scanner sc = new Scanner(System.in);
		int userNum = 0;
		System.out.printf("���ڸ� �Է��ϼ��� : ");
		userNum = sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i<=userNum; i++) {
			String userNum2 = Integer.toString(i);
				for (int j = 0; j < userNum2.length(); j++) {
//					System.out.println((userNum3.charAt(j)));
					if(((int)(userNum2.charAt(j)) % 3 == 0) && ((userNum2.charAt(j)) != '0')) {
						System.out.println(i +"¦ ");
						sum++;
					}
				}
			}
		System.out.println("\n" + sum);
		
	}
}
