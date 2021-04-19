import java.io.File;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class B03_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("정수를 입력 : ");
		int a =sc.nextInt();
		System.out.println("입력하신 값은 " +a + "입니다.");
		System.out.println("입력하신 값에 3을 곱하면 " +a*3 + "입니다.");
		System.out.println("1000과 입력하신 값의 차이는 "+ Math.abs(1000-a) + "입니다.");
		
		System.out.print("실수를 입력 : ");
		double b = sc.nextDouble();
		System.out.println("두 번째로 입력하신 값은  " +b+"입니다.");
		System.out.println("첫 번째 값과 두 번째 값을 곱하면 " + a*b + "입니다.");
	}
}
