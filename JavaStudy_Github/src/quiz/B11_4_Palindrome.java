package quiz;

import java.util.Scanner;

public class B11_4_Palindrome {
	public static void main(String[] args) {
		//����ڷκ��� �ܾ �ϳ� �Է¹ް� �ش� �ܾ ȸ���̶�� "PALINDROME"�� ���
		//ȸ���� �ƴϸ� "NOT PALINDROME"�� ����� ������.
		//ȸ��? MOM, BOB, ABBA, MADAMó�� �¿� ��Ī�� �ܾ�
		
		Scanner sc = new Scanner(System.in);
		String word;
		String result = "PALINDROME";
		int i;
		System.out.printf("�ܾ �Է��� ������ : ");
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
