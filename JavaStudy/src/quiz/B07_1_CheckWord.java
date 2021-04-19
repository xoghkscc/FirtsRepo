package quiz;

import java.util.Scanner;

public class B07_1_CheckWord {
	public static void main(String[] args) {
		//사용자로부터 단어를 하나 입력받고 첫 번째 글자와 마지막 번째 글자가 일치하면 "ok"
		
		Scanner sc = new Scanner(System.in);
		String userWord;
		char userFirst, userLast;
		
		System.out.printf("단어를 입력 하세요 : ");
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
