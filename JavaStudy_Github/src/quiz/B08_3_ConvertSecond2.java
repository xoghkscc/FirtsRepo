package quiz;

public class B08_3_ConvertSecond2 {
	public void convert(int sec) {
		int year=0, day=0, hour=0, min=0;
				
		while(sec>=60) {
			min++;
			sec -= 60;
			while(min>=60) {
				hour++;
				min -= 60;
				while(hour>=24) {
					day++;
					hour -= 24;
					while(day>=365) {
						year++;
						day -= 365;
					}
				}
			}
		}
		System.out.printf("%d년 %d일 %d시간 %d분 %d초\n",year, day, hour ,min ,sec);
		
//		if(sec>=0) {
//			if(year == 0) {
//				if(day == 0) {
//					if(hour == 0) {
//						if(min == 0) {
//							System.out.printf("%s초",sec);
//						}else {
//							System.out.printf("%s분 %s초",min ,sec);
//						}
//					}else {
//						System.out.printf("%s시간 %s분 %s초",hour ,min ,sec);
//					}
//				}else {
//					System.out.printf("%s일 %s시간 %s분 %s초",day, hour ,min ,sec);
//				}
//			}else {
//				System.out.printf("%s년 %s일 %s시간 %s분 %s초",year, day, hour ,min ,sec);
//			}
//		}else {
//			System.out.println("잘못 입력하였습니다.");
//		}
	}
}
