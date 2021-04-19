package quiz;

public class B14_1_Gugudan {
	public static void main(String[] args) {
		//1. 구구단을 다음과 같이 가로로 출력해보세요
		//2단: 2x1=2 2x2=4 .... 2x9=18
		//3단 : 3x1=3.....
		//..
		
		//2단 구구단을 다음과 같이 세로로 출력해보세요
		//2단	3단	4단	..
		//2x1=2...
		
		for (int i = 2; i < 10; i++) {
			System.out.printf(i+"단 : \t");
			for (int j = 1; j < 10; j++) {
				System.out.printf("%dX%d=%d\t",i,j,i*j);
			}
			System.out.printf("\n");
		}
	
		System.out.println("------------------------------------------------------------------------------------------");
		
		for (int i = 2; i < 10; i++) {
			System.out.printf(i+"단\t");
		}
		System.out.printf("\n");
		
		for (int j = 1; j <10; j++) {		
			for (int i = 2; i < 10; i++) {
				System.out.printf("%dX%d=%d\t",i,j,i*j);
			}
			System.out.println();
		}
		
	}
}
