import myobj.item.Inventory;

public class C07_Abstract {
	public static void main(String[] args) {
		Vehicle v1 = new Bus();
		v1.ride();
		
		//익명 클래스-Vehicle은 추상 클래스라 아래처럼 인스턴스화를 하려면
		//오버라이드를 즉석으로 해야함
		Vehicle v2 = new Vehicle() {
			@Override
			void ride() {
				System.out.println("즉석해서 구현한 탈것");
			}
		};
	}
}

abstract class Vehicle{
	abstract void ride(); 
}

class Bus extends Vehicle{
	void ride() {
		System.out.println("요금을 내고 타야함");
	}
}

class Bike extends Vehicle{

	@Override
	void ride() {
		System.out.println("Vehicle에 있는 ride 메서드를 오버라이드 함");		
	}
}

