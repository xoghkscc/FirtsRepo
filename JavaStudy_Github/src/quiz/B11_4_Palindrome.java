package quiz;

import java.util.Scanner;

public class B11_4_Palindrome {
	public static void main(String[] args) {
		//사용자로부터 단어를 하나 입력받고 해당 단어가 회문이라면 "PALINDROME"을 출력
		//회문이 아니면 "NOT PALINDROME"을 출력해 보세요.
		//회문? MOM, BOB, ABBA, MADAM처럼 좌우 대칭인 단어
		
		Scanner sc = new Scanner(System.in);
		String word;
		String result = "PALINDROME";
		int i;
		System.out.printf("단어를 입력해 보세요 : ");
		word = sc.next();
		char[] alpha = new char[word.length()];
		
//		if(word.length() % 2 ==0) {
			for(i = 0; i<word.length(); i++) {
				alpha[i] = word.charAt(i);	
			}
			for(i = 0; i<word.length(); i++) {
				// if (word.charAt(i) != word.charAt(word.length() - 1 - i))
				if(alpha[i]!=alpha[word.length()-1-i]) {
					result = "NOT PALINDROME";
				}
			}
//		}else {
//			for(i = 0; i<word.length(); i++) {
//				alpha[i] = word.charAt(i);
//			}
//			
//			for(i = 0; i<word.length(); i++) {
//				if((i != (word.length()+1)/2 )) {
//					if((alpha[i]!=alpha[word.length()-i-1])) {
//						result = "NOT PALINDROME";
//					}
//				}
//			}
//		}
		System.out.println(result);
			
	}
}
