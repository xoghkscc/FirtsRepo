package quiz;

import java.util.Scanner;

public class B03_1_GuestAge {
	public static void main(String[] args) {
		int age;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("태어난 년도를 입력하세요 : ");
		int birth = sc.nextInt();
		
		System.out.printf("올해 년도를 입력하세요 : ");
		int year = sc.nextInt();
		
		age = year-birth + 1;
		
		System.out.printf("당신의 나이는 %d살입니다.", age);
		
	}
}
