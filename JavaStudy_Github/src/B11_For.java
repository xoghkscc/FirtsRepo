public class B11_For {
	public static void main(String[] args) {
		
		//���� �⺻���� ������ for��
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
//				season = "�ܿ�";
//				break;
//			case 3:
//			case 4:
//			case 5:
//				season = "��";
//				break;
//			case 6:
//			case 7:
//			case 8:
//				season = "����";
//				break;
//			case 9:
//			case 10:
//			case 11:
//				season = "����";
//				break;
//			default:
//				season = "�߸��� ����";
//				break;
//			}
//			System.out.printf("%d���� %s�Դϴ�.\n", month, season);
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
		
		//continue�� �̿��Ͽ� 5000���� 100���̿� �����ϴ� Ȧ���� ���
		
//		for(int i = 100; i<5001; i++) {
//			if(i % 2 == 0) {
//				continue;
//			}
//			System.out.println(i);
//		}
		// 80���� 333������ 3�� ����� ������ ���غ���
		int sum = 0;
		
		for(int i = 80; i<=333; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("80 ���� 333������ 3�� ��� ���� : " +sum);
		System.out.println();
	}
}
