package quiz;

import java.util.Scanner;

public class B15_4_Count369Ver3 {
	public static void main(String[] args) {
		int input =40;
		int clap = 0;
		
		for (int i = 1; i <= input; i++) {
			int testValue = i;
			System.out.printf(i + " :");
			
			while(testValue > 0) {
				int digit =  testValue % 10;
				
				if(digit !=0 && digit % 3 == 0) {
					clap++;
					System.out.printf("¦");
				}
				testValue /= 10;
				
			}
			System.out.println();
		}
		

		
		
	}
}
