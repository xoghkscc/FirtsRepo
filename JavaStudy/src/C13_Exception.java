import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C13_Exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ݵ�� ���ڸ� �Է� :");
		try {
			System.out.println("�Է��� ���� : " +sc.nextInt());
		} catch(InputMismatchException e) {
			e.printStackTrace();//������ ���� ���� ���
			System.out.println("getMessage : " +e.getMessage());
			System.out.println("�̻��� �� �Է���");
			return;
		} catch(IllegalStateException e) {
			System.out.println("��ĳ�ʰ� �����ִµ�");
		} catch(NoSuchElementException e) {
			System.out.println("��ĳ�ʿ� ���� ������ ���µ�");
		}finally {
			System.out.println("�䳢 ����");
		}
		System.out.println("���α׷��� ���������� ����Ǿ����ϴ�.");
	}
}
