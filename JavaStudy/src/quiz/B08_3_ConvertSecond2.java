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
		System.out.printf("%d�� %d�� %d�ð� %d�� %d��\n",year, day, hour ,min ,sec);
		
//		if(sec>=0) {
//			if(year == 0) {
//				if(day == 0) {
//					if(hour == 0) {
//						if(min == 0) {
//							System.out.printf("%s��",sec);
//						}else {
//							System.out.printf("%s�� %s��",min ,sec);
//						}
//					}else {
//						System.out.printf("%s�ð� %s�� %s��",hour ,min ,sec);
//					}
//				}else {
//					System.out.printf("%s�� %s�ð� %s�� %s��",day, hour ,min ,sec);
//				}
//			}else {
//				System.out.printf("%s�� %s�� %s�ð� %s�� %s��",year, day, hour ,min ,sec);
//			}
//		}else {
//			System.out.println("�߸� �Է��Ͽ����ϴ�.");
//		}
	}
}
