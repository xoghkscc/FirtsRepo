
public class B09_Operator3 {
	public static void main(String[] args) {
		//ex �ʿ��� �ٱ��� ���� ���ϱ�
		int apple = 25;
		int size = 10;
		
		int needs = apple % size == 0 ? apple / size : apple / size + 1;
		
		System.out.println("�ʿ��� �ٱ��� ������ " + needs + "���Դϴ�.");
		
		boolean isEven = apple % 2 == 0;
		
		System.out.printf("����� ������ %s�Դϴ�.", isEven ? "¦��" : "Ȧ��");
	}
}
