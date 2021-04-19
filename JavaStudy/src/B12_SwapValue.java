
public class B12_SwapValue {
	public static void main(String[] args) {
		int a = 10, b = 20, c;
		System.out.printf("a : %d, b : %d\n", a, b);
		c=a;
		//c에 a를 잠시 보관
		a=b;
		//a에 b를 넣음
		b=c;
		//아까 보내놨던 c를 b에 넣음
		
		
		
		
		System.out.printf("a : %d, b : %d\n", a, b);
	}
}
