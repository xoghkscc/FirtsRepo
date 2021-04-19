package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class B14_4_GCD2 {	
	public static void main(String[] args) {
		//두 숫자를 입력받고 두 숫자의 최대공약수를 구해보세요.
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		System.out.printf("첫 번째 숫자를 입력해 보세요 : ");
		num1 = sc.nextInt();
		
		System.out.printf("두 번째 숫자를 입력해 보세요 : ");
		num2 = sc.nextInt();
		
		int gcd=1;
		
		ArrayList factor1 = new ArrayList();
		ArrayList factor2 = new ArrayList();
		
		for(int i=1; i<=num1; i++) {
			if(num1 % i == 0) {
				factor1.add(i);

			}
		
		}
		for(int j=1; j<=num2; j++) {
			if(num2 % j == 0) {
				factor2.add(j);

			}
		}

		for(int i=0; i<factor1.size(); i++) {
			for(int j=0; j<factor2.size(); j++) {
				if((int)factor1.get(i) == (int)factor2.get(j)) {
					gcd = (int) factor1.get(i);
				}
			}
		}
		System.out.printf("%d과 %d의 최대 공약수는 %d",num1, num2, gcd);
		
				
	}
}
