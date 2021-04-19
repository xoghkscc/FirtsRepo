package quiz;

import java.util.Scanner;

public class B14_3_GCD {	
	public static void main(String[] args) {
		//두 숫자를 입력받고 두 숫자의 최대공약수를 구해보세요.
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		System.out.printf("첫 번째 숫자를 입력해 보세요 : ");
		num1 = sc.nextInt();
		
		System.out.printf("두 번째 숫자를 입력해 보세요 : ");
		num2 = sc.nextInt();
		
		int factor1=0, factor2=0, gcd=1;
		
		for(int i=1; i<=num1; i++) {
			if(num1 % i == 0) {
				factor1 = i;
				for(int j=1; j<=num2; j++) {
					if(num2 % j == 0) {
						factor2 = j;
						if(factor1 == factor2) {
							gcd = factor1;
						}
					}
					
				}
			}
		}
		System.out.println(gcd);	
				
	}
}
