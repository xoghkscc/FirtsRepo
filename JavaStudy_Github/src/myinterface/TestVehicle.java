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
		//air.wheel(4); Airplane은 Land인터페이스를 상속받지 않기 때문에 안됨
		System.out.println();
//		car.height(200); Car는 Fly인터페이스를 상속받지 않기 때문에 안됨
		air.height(4000);
	}
}