import java.util.Random;

public class B16_Random {
	public static void main(String[] args) {
//		for(int i=0; i<10; i++) {
//			System.out.println((int)Math.floor(Math.random()*31+30));
//		}
		
		//1~45�� ���� ���ڸ� 7�� ����غ�����.
		
//		for (int i = 0; i < 7; i++) {
//			System.out.println((int)(Math.random()*45+1));
//		}
		
		Random ran = new Random();
		
		System.out.println(ran.nextInt()); //-816019298
		System.out.println(ran.nextInt()); //-1612082284
		System.out.println(ran.nextInt(45)+1); // 1~ 45�� ���� ����
		System.out.println(ran.nextInt(41)+30); // 30~70�� ���� ����
		System.out.println(ran.nextInt());
		System.out.println(ran.nextBoolean() ? "��" : "��");
		
		
	}
}
