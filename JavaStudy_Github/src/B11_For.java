public class B11_For {
	public static void main(String[] args) {
		
		//가장 기본적인 형태의 for문
//		for(int i = 0; i< 10; i++) {
//			System.out.println("hello world" + i);
//		}
//		int x = 0;
//		
//		for(; x<10;) {
//			System.out.println(x);
//			
//		}
		
//		for(int month = 1; month <= 12; month++) {
//			String season;
//			
//			switch (month) {
//			case 12:
//			case 1:
//			case 2:
//				season = "겨울";
//				break;
//			case 3:
//			case 4:
//			case 5:
//				season = "봄";
//				break;
//			case 6:
//			case 7:
//			case 8:
//				season = "여름";
//				break;
//			case 9:
//			case 10:
//			case 11:
//				season = "가을";
//				break;
//			default:
//				season = "잘못된 계절";
//				break;
//			}
//			System.out.printf("%d월은 %s입니다.\n", month, season);
//		}
//		int count = 0;
//		for(;;) {
//			System.out.println(++count);
//			break;
//		}
		
//		for(int i = 1; i<50; i++) {
//			System.out.println("i : "+i);
//			
//			if(i%10 != 0 ) {
//			continue;
//			}
//			System.out.println();
//		}
		
		//continue를 이용하여 5000부터 100사이에 존재하는 홀수만 출력
		
//		for(int i = 100; i<5001; i++) {
//			if(i % 2 == 0) {
//				continue;
//			}
//			System.out.println(i);
//		}
		// 80부터 333사이의 3의 배수의 총합을 구해보기
		int sum = 0;
		
		for(int i = 80; i<=333; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("80 부터 333사이의 3의 배수 총합 : " +sum);
		System.out.println();
	}
}
