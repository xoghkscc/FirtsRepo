import java.io.File;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class B03_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("������ �Է� : ");
		int a =sc.nextInt();
		System.out.println("�Է��Ͻ� ���� " +a + "�Դϴ�.");
		System.out.println("�Է��Ͻ� ���� 3�� ���ϸ� " +a*3 + "�Դϴ�.");
		System.out.println("1000�� �Է��Ͻ� ���� ���̴� "+ Math.abs(1000-a) + "�Դϴ�.");
		
		System.out.print("�Ǽ��� �Է� : ");
		double b = sc.nextDouble();
		System.out.println("�� ��°�� �Է��Ͻ� ����  " +b+"�Դϴ�.");
		System.out.println("ù ��° ���� �� ��° ���� ���ϸ� " + a*b + "�Դϴ�.");
	}
}
