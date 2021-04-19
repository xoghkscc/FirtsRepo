package quiz;

public class B06_2_AppleQuiz2 {
	
	public void apple(int appleCount) {
		int appleBasket;
		
		appleBasket = appleCount/10;
		
		if(appleCount<0) {
			System.out.println("사과의 개수를 잘못 입력하셨습니다.");
		}else {
			if(appleCount % 10 != 0) {
				System.out.printf("필요한 바구니의 개수는 %d입니다", appleBasket+1);
			}else {
				System.out.printf("필요한 바구니의 개수는 %d입니다", appleBasket);
			}
		}
	}
	
}
