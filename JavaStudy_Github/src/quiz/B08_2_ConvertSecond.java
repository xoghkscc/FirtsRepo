package quiz;

import java.util.Scanner;

public class B08_2_ConvertSecond {
	public static void main(String[] args) {
		//초를 입력받으면 년/일/시간/분/초로 변환하여 출력해보세요
		//필요없는 단위는 출력하지 말것 ex : 0년 0일 5시간 0분 20초인 경우 0년 0일은 나오지 않아야 함
		
		int year=0, day=0, hour=0, min=0, sec;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("현재 초를 입력 하세요 : ");
		sec = sc.nextInt();
			
		B08_3_ConvertSecond2 cs = new B08_3_ConvertSecond2();
		cs.convert(sec);
		
		if(sec>=60) {
			min = sec / 60;
			sec = sec % 60;
		}
		
		if(min>=60) {
			hour = min / 60;
			min = min % 60;
		}
		if(hour>=24) {
			day = hour / 24;
			hour = hour % 24;
		}
		if(day>=365) {
			year = day / 365;
			day = day % 365;
		}
		if(sec>=0) {
			if(year == 0) {
				if(day == 0) {
					if(hour == 0) {
						if(min == 0) {
							System.out.printf("%d초",sec);
						}else {
							System.out.printf("%d분 %d초",min ,sec);
						}
					}else {
						System.out.printf("%d시간 %d분 %d초",hour ,min ,sec);
					}
				}else {
					System.out.printf("%d일 %d시간 %d분 %d초",day, hour ,min ,sec);
				}
			}else {
				System.out.printf("%d년 %d일 %d시간 %d분 %d초",year, day, hour ,min ,sec);
			}
		}else {
			System.out.println("잘못 입력하였습니다.");
		}
		System.out.println("\n");

	}
}
