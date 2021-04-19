import java.util.Random;

public class B16_Random {
	public static void main(String[] args) {
//		for(int i=0; i<10; i++) {
//			System.out.println((int)Math.floor(Math.random()*31+30));
//		}
		
		//1~45의 랜덤 숫자를 7개 출력해보세요.
		
//		for (int i = 0; i < 7; i++) {
//			System.out.println((int)(Math.random()*45+1));
//		}
		
		Random ran = new Random();
		
		System.out.println(ran.nextInt()); //-816019298
		System.out.println(ran.nextInt()); //-1612082284
		System.out.println(ran.nextInt(45)+1); // 1~ 45의 랜덤 정수
		System.out.println(ran.nextInt(41)+30); // 30~70의 랜덤 정수
		System.out.println(ran.nextInt());
		System.out.println(ran.nextBoolean() ? "앞" : "뒤");
		
		
	}
}
