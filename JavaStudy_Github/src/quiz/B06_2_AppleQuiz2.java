package quiz;

public class B06_2_AppleQuiz2 {
	
	public void apple(int appleCount) {
		int appleBasket;
		
		appleBasket = appleCount/10;
		
		if(appleCount<0) {
			System.out.println("����� ������ �߸� �Է��ϼ̽��ϴ�.");
		}else {
			if(appleCount % 10 != 0) {
				System.out.printf("�ʿ��� �ٱ����� ������ %d�Դϴ�", appleBasket+1);
			}else {
				System.out.printf("�ʿ��� �ٱ����� ������ %d�Դϴ�", appleBasket);
			}
		}
	}
	
}
