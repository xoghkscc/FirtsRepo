
public class B09_Operator3 {
	public static void main(String[] args) {
		//ex 필요한 바구니 개수 구하기
		int apple = 25;
		int size = 10;
		
		int needs = apple % size == 0 ? apple / size : apple / size + 1;
		
		System.out.println("필요한 바구니 개수는 " + needs + "개입니다.");
		
		boolean isEven = apple % 2 == 0;
		
		System.out.printf("사과의 개수는 %s입니다.", isEven ? "짝수" : "홀수");
	}
}
