package quiz;

import java.util.Scanner;

public class B11_5_Reverse {
	public static void main(String[] args) {
		//����ڰ� ������ �Է��ϸ� �� ������ �Ųٷ� ����� ������.
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��� ������.");
		String sentence = sc.nextLine();
		
		for(int i = sentence.length()-1; i>=0; i-- ) {
			System.out.println(sentence.charAt(i));
		}
	}
}
