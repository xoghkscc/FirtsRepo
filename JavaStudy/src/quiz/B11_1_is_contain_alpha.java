package quiz;

import java.util.Scanner;

public class B11_1_is_contain_alpha {
	public static void main(String[] args) {
		//����ڰ� �Է��� ���ڿ��� ���ĺ��� ���ԵǾ� ������ true�� ���
		
		Scanner sc = new Scanner(System.in);
		String word=null;
		
		boolean m= false;
		System.out.printf("���ڿ��� �Է��� ������ :");
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
