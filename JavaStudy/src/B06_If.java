
public class B06_If {
	public static void main(String[] args) {
		
		int a = 10;
		
		if(a < 5) {
			System.out.println("hello");
		}else if(a<15) {
			System.out.println("�ȴ�");			
		}else if(a>0) {
			System.out.println("���");
		}
		
		char ch = '$';
		
		if(ch >='��' && ch <= '�R') {
			System.out.println("ch�� ����ִ� ���� �ѱ��Դϴ�." + ch);
		} else if(ch>='a' && ch <= 'z') {
			System.out.println("ch�� �����" + ch);
		}
		
		else {
			System.out.println("ch�� ����ִ� ���� �ѱ��� �ƴմϴ�." + ch);
		}
		
	} 

}
