package myinterface;

import myinterface.Vehicle.Speed;

class TestVehicle{
	
	public static void test(Speed speed, int x, int y) {
		speed.speed();
		speed.move(x, y);
		speed.ride();
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		Airplane air = new Airplane();
		
		test(car, 10, 20);
		test(air, 300, 500);
		System.out.println();
		car.wheel(4);
		//air.wheel(4); Airplane�� Land�������̽��� ��ӹ��� �ʱ� ������ �ȵ�
		System.out.println();
//		car.height(200); Car�� Fly�������̽��� ��ӹ��� �ʱ� ������ �ȵ�
		air.height(4000);
	}
}