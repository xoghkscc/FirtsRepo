
public class B08_Switch {
	public static void main(String[] args) {
		int a = 11;
		
		switch (a % 2) {
		case 0:
			System.out.println("a�� ¦��");
			break;

		case 1:
			System.out.println("a�� Ȧ��");
			break;

		default:
			break;
		}
		
		char grade = 'e';
		
		switch (grade) {
		case 'E': case 'e':
			System.out.println("��ü ������");
			break;
		case 'K': case 'k':
			System.out.println("12�� �̻� ������");
			break;
		case 'Y':
			System.out.println("15�� �̻� ������");
			break;
		case 'A':
			System.out.println("û�ҳ� �����Ұ��Դϴ�.");
			break;

		default:
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			break;
		}
	}
}
