
public class B14_InnerLoop {
	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.printf("========================�ٱ��� �ݺ��� %d\n", i);
//			for (int j = 0; j < 8; j++) {
//				System.out.printf("-------------���� �ݺ��� %d-%d\n", i, j);
//				for (int k = 0; k < 3; k++) {
//					System.out.printf("+++++++���� ���� �ݺ��� %d-%d-%d\n",i,j,k);
//				}
//			}
//		}
		
		//#���� �ݺ������� ������ ����غ���
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d X %d = %d\n", i, j, i*j);
			}
			System.out.println("-------------------------");
		}
	}
}
