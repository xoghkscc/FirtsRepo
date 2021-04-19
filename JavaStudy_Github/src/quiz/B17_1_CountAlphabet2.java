package quiz;

import java.util.Scanner;

public class B17_1_CountAlphabet2 {
	public static void main(String[] args) {

		// 사용자로부터 문장을 하나 입력받고 해당 문장에 어떤 알파벳이 몇 번 등장했는지 세어ㅓ 모두 출력해보ㅔ요
		// 대소문자 구분 안함

		Scanner sc = new Scanner(System.in);
		System.out.printf("문장을 입력하세요 : ");
		String sentence = sc.nextLine();
		char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] sentence2 = sentence.toCharArray();
		int alphaCount[] = new int[26];
		
		int gap = 'a' - 'A';

		for (int i = 0; i < sentence2.length; i++) {
			if (sentence2[i] >= 'A' && sentence2[i] <= 'Z') {
				sentence2[i] += gap;
			}
			if(sentence2[i]>='a' &&sentence2[i]<='z') {
				alphaCount[sentence2[i] - 'a']++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (alphaCount[i] != 0) {
				System.out.printf("알파벳 %c의 %d번 있습니다\n", alpha[i], alphaCount[i]);
			}
		}

	}
}
