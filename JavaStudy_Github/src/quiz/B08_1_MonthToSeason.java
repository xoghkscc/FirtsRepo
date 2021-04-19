package quiz;

import java.util.Scanner;

public class B08_1_MonthToSeason {
	public static void main(String[] args) {
		//사용자로부터 달을 입력받으면 해당하는 계절을 출력해보세요.

		Scanner sc = new Scanner(System.in);
		int month;

		System.out.printf("몇 월인지 입력하세요 :");

		month = sc.nextInt();
 		String season = null;

		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
		System.out.println(season + "입니다.");
			
	}
}
