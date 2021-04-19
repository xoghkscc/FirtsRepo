package myinterface;

import myinterface.Vehicle.Fly;
import myinterface.Vehicle.Land;
import myinterface.Vehicle.Speed;

public class Vehicle {

	interface Fly {
		public void height(int height);
	}

	interface Land {// land : ��
		public void wheel(int wheel);
	}

	interface Speed {
		public void ride();
		public void speed();
		public void move(int x, int y);
	}

}

class Car implements Land, Speed {

	public void speed() {
		System.out.println("�ڵ����� ���ǵ�� 100km/h�Դϴ�.");
	}

	public void move(int x, int y) {
		System.out.printf("�ڵ����� %d, %d ��ǥ�� �̵�\n", x, y);
	}

	public void ride() {
		System.out.println("�������� �ٴմϴ�");
	}

	public void wheel(int wheel) {
		System.out.println("�ڵ����� �� ������ " + wheel + "�Դϴ�.");
	}

}

class Airplane implements Fly, Speed {
	public void speed() {
		System.out.println("������� ���ǵ�� 400km/h�Դϴ�.");
	}

	public void move(int x, int y) {
		System.out.printf("������ %d, %d ��ǥ�� �̵�\n", x, y);
	}
	public void ride() {
		System.out.println("�ַ� �ϴÿ����� �ٴմϴ�");

	}
	public void height(int height) {
		System.out.println("������ ��" + height + "km ����� �ٴմϴ�.");
	}
}
