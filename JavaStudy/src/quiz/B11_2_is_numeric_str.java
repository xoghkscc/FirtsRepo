package quiz;

import java.util.Scanner;

public class B11_2_is_numeric_str {
	public static void main(String[] args) {
		//�Է¹޴� ���ڿ��� ���ڸ� ���ԵǾ� ������  result�� 1
		//�ٸ� ���ڰ� ���ԵǾ� �ִٸ� result�� 0
		Scanner sc = new Scanner(System.in);
		int result = 1;
		String word;
		
		System.out.printf("���ڿ��� �Է��ϼ���. :");
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

