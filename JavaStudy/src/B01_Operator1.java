
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
		System.out.println("���� : " +Math.pow(a, 3));
		System.out.println("������ : "+Math.sqrt(2));
		System.out.println("���밪 : "+Math.abs(-25));
		System.out.println("�ݿø� : "+Math.round(3.335));
		System.out.println("�Ҽ� ��°�ڸ����� �ݿø� : "+Math.round(3.335*100)/100.0);
		System.out.println("�ø� : " + Math.ceil(1.1));
		System.out.println("���� : " + Math.floor(1.1));
		System.out.println("�� ū ���� : " + Math.max(1000, 1500));
		System.out.println("�� ū ���� : " + Math.min(1000, 1500));
		
		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(a ^ b);
		System.out.println(8 << 2);
		System.out.println(8 >> 2);
		
		
	}
}
