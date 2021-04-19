package quiz;

import java.util.Scanner;

public class B11_5_Reverse {
	public static void main(String[] args) {
		//사용자가 문장을 입력하면 그 문장을 거꾸로 출력해 보세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("문장을 입력해 보세요.");
		String sentence = sc.nextLine();
		
		for(int i = sentence.length()-1; i>=0; i-- ) {
			System.out.println(sentence.charAt(i));
		}
	}
}
