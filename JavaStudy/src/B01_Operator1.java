
public class B01_Operator1 {
	public static void main(String[] args) {
		int a = 10, b = 7;
		double c = 7.0;
		
		System.out.println("+ : "+ (a + b));
		System.out.println("- : "+ (a - b));
		System.out.println("* : "+ a * b);
		System.out.println("/ : "+ a / b);
		System.out.println("/ : "+ a / c);
		System.out.println("/(double) : "+ a/(double)b);
		System.out.println("/(double) : "+ (double)a/b);
		System.out.println("/(float) : "+ (float)a/b);
		System.out.println("% : "+ a % b );
		System.out.println("제곱 : " +Math.pow(a, 3));
		System.out.println("제곱근 : "+Math.sqrt(2));
		System.out.println("절대값 : "+Math.abs(-25));
		System.out.println("반올림 : "+Math.round(3.335));
		System.out.println("소수 셋째자리에서 반올림 : "+Math.round(3.335*100)/100.0);
		System.out.println("올림 : " + Math.ceil(1.1));
		System.out.println("내림 : " + Math.floor(1.1));
		System.out.println("더 큰 숫자 : " + Math.max(1000, 1500));
		System.out.println("더 큰 숫자 : " + Math.min(1000, 1500));
		
		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(a ^ b);
		System.out.println(8 << 2);
		System.out.println(8 >> 2);
		
		
	}
}
