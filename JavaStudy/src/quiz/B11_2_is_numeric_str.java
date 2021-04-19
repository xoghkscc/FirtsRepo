package quiz;

import java.util.Scanner;

public class B11_2_is_numeric_str {
	public static void main(String[] args) {
		//입력받는 문자열에 숫자만 포함되어 있으면  result가 1
		//다른 문자가 포함되어 있다면 result가 0
		Scanner sc = new Scanner(System.in);
		int result = 1;
		String word;
		
		System.out.printf("문자열을 입력하세요. :");
		word = sc.next();
		
		for(int i = 0; i<= word.length()-1; i++) {
			char alpha = word.charAt(i);
			System.out.println(alpha);
			if(alpha<'0' || alpha>'9'){
				result = 0;
				break;
			}
		}
		System.out.println("result : "+ result);
	}
}

