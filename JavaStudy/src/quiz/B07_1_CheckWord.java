package quiz;

import java.util.Scanner;

public class B07_1_CheckWord {
	public static void main(String[] args) {
		//����ڷκ��� �ܾ �ϳ� �Է¹ް� ù ��° ���ڿ� ������ ��° ���ڰ� ��ġ�ϸ� "ok"
		
		Scanner sc = new Scanner(System.in);
		String userWord;
		char userFirst, userLast;
		
		System.out.printf("�ܾ �Է� �ϼ��� : ");
		userWord = sc.nextLine();
		userFirst = userWord.charAt(0);
		userLast = userWord.charAt(userWord.length()-1);
		
		if(userFirst == userLast) {
			System.out.println("OK");
		}else {
			System.out.println("NOT OK");
		}
	}
}
