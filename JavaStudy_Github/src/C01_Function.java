
public class C01_Function {
	public static void main(String[] args) {
		int basket = apple_baskert(123, 10);
		System.out.println(basket);
		
	}
	
		
	
	public static void print_rabbit() {
		System.out.println("/)/)");
		System.out.println("( ..)");
		System.out.println("(  >$");
	}
	
	//ex: ����� ������ �����ϸ� �ʿ��� �ٱ����� ������ �˷��ִ� �Լ�
	
	public static int apple_baskert(int apple, int size) {
		int result;
		if(apple % size ==0) {
			result = apple / size;
		}else {
			result = apple / size + 1;
		}
		
		return result;
	}
}
