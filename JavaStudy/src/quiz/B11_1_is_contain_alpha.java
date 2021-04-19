package quiz;

import java.util.Scanner;

public class B11_1_is_contain_alpha {
	public static void main(String[] args) {
		//사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true를 출력
		
		Scanner sc = new Scanner(System.in);
		String word=null;
		
		boolean m= false;
		System.out.printf("문자열을 입력해 보세요 :");
		word = sc.next();
		
		for(int i = 0; i<= word.length()-1; i++) {
			char alpha = word.charAt(i);
			if((alpha>='A' && alpha<='Z') || (alpha>='a' && alpha<='z')){
				m = true;
				break;
			}
		}
		System.out.println(m);
	}
}
