
public class B14_InnerLoop {
	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.printf("========================바깥쪽 반복문 %d\n", i);
//			for (int j = 0; j < 8; j++) {
//				System.out.printf("-------------안쪽 반복문 %d-%d\n", i, j);
//				for (int k = 0; k < 3; k++) {
//					System.out.printf("+++++++제일 안쪽 반복문 %d-%d-%d\n",i,j,k);
//				}
//			}
//		}
		
		//#다중 반복문으로 구구단 출력해보기
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d X %d = %d\n", i, j, i*j);
			}
			System.out.println("-------------------------");
		}
	}
}
