
public class C12_Interface {
	public static void main(String[] args) {
		new OrangeTree().click();
	}
}

interface CanClick{
	int a = 10;//�������̽� ������ ������ �ڵ����� final static�� ��
	
	//abstract �Ƚᵵ ��
	//�������̽� ���ο� �޼��带 ������ �� default�� ���̸� �⺻ ������ ����-
	default void click() {
		System.out.println("Ŭ�� �������̽��� �޷��ִ� Ŭ������ �⺻ ����." + "(�������̵��ؼ� ������ּ���.)");
	}
}

interface CanPunch{
	abstract void punch();
	
//	void click() {//�տ� default�� ���� ������ �۵����� ����
//		System.out.println("����");
//	}
}

class OrangeTree implements CanClick, CanPunch{


	@Override
	public void punch() {
		
	}
	
}

