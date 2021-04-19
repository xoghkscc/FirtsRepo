import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.jar.Attributes.Name;

public class C15_Throw {
	public static void main(String[] args) {
		C15_Throw instance = new C15_Throw();
		try {
			instance.dangerous_method();
			instance.dangerous_method2();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭 ����: " + e.getMessage());
		}

		try {
			instance.checkEven(20);// checkEven�� if�� �Ǵ��ϰ� Ȧ���̸� throw new NotEvenExcption()�� �����ؼ� ����ó���ϰ� ��
			instance.checkOdd(14);// checkOdd�� if�� �Ǵ��ϰ� Ȧ���̸� throw new NotOddException()�� �����ؼ� ����ó���ϰ� ��(�����ƴ�)
		} catch (NotEvenExcption e) {
			System.out.println("¦�� �ƴ� �ͼ��� �߻�! " + e.getMessage());
		} catch (NotOddException e) {
			System.out.println("Ȧ�� �ƴ� �ͼ��� �߻�!" + e.getMessage());
		}
	}
	public void checkEven(int num) throws NotEvenExcption {//����ó���� �޼��带 �ҷ��� ���� ó���� �ѱ��
		if (num % 2 == 0) {
			System.out.println("¦���Դϴ�");
		} else {
			throw new NotEvenExcption();// ����ó������ ������ �������� ��(Exception�� ��ӹ޾ұ� ����)
		}
		System.out.println("checkEven �޼��尡 ���� ����");
	}
	public void checkOdd(int num) {
		if (num % 2 == 1) {
			System.out.println("Ȧ���Դϴ�");
		} else {
			throw new NotOddException();// RuntimeExceptiond�� ��ӹ޾ұ�� ����ó������ �ʾƵ� �������� �ȶ�
		}
		System.out.println("checkOdd �޼��尡 ���� ����");
	}
	
//¦���� �ƴ� �� �߻���ų ����(����ó�� ���� ������ ������ �Ұ�)
	class NotEvenExcption extends Exception {
		public NotEvenExcption() {
			super("¦���� �ƴϾ �߻��ϴ� ����");
		}
	}
//Ȧ���� �ƴ� �� �߻���ų ����(����ó�� ���� �ʾƵ� �������� ���� �ʴ� ����)
	class NotOddException extends RuntimeException {
		public NotOddException() {
			super("Ȧ���� �ƴϾ �߻��ϴ� ����");
		}
	}
	
	public void dangerous_method() {
		// ������ ������ �о���� ���� �غ� ����
		File f = new File("D:\\nameless.txt");
		try {
			FileReader reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dangerous_method2() {
		throw new ArrayIndexOutOfBoundsException("�׳� �������");
	}

}
