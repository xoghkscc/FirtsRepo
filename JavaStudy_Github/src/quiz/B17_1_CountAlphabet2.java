package quiz;

import java.util.Scanner;

public class B17_1_CountAlphabet2 {
	public static void main(String[] args) {

		// ����ڷκ��� ������ �ϳ� �Է¹ް� �ش� ���忡 � ���ĺ��� �� �� �����ߴ��� ����� ��� ����غ��Ŀ�
		// ��ҹ��� ���� ����

		Scanner sc = new Scanner(System.in);
		System.out.printf("������ �Է��ϼ��� : ");
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
				System.out.printf("���ĺ� %c�� %d�� �ֽ��ϴ�\n", alpha[i], alphaCount[i]);
			}
		}

	}
}
