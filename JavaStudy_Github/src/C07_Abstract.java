import myobj.item.Inventory;

public class C07_Abstract {
	public static void main(String[] args) {
		Vehicle v1 = new Bus();
		v1.ride();
		
		//�͸� Ŭ����-Vehicle�� �߻� Ŭ������ �Ʒ�ó�� �ν��Ͻ�ȭ�� �Ϸ���
		//�������̵带 �Ｎ���� �ؾ���
		Vehicle v2 = new Vehicle() {
			@Override
			void ride() {
				System.out.println("�Ｎ�ؼ� ������ Ż��");
			}
		};
	}
}

abstract class Vehicle{
	abstract void ride(); 
}

class Bus extends Vehicle{
	void ride() {
		System.out.println("����� ���� Ÿ����");
	}
}

class Bike extends Vehicle{

	@Override
	void ride() {
		System.out.println("Vehicle�� �ִ� ride �޼��带 �������̵� ��");		
	}
}

