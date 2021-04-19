package quiz;

import java.util.Scanner;

public class B03_3_celToFahr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double cel, fahr;
		
		System.out.printf("섭씨 온도를 입력하세요 : ");
		cel = sc.nextDouble();
		fahr = cel*1.8+32;
		
		System.out.printf("현재 섭씨 온도는 %.1f이고 화씨 온도는 %.1f입니다.",cel, fahr);
	}
}
