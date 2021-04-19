package myinterface;

import myinterface.Vehicle.Fly;
import myinterface.Vehicle.Land;
import myinterface.Vehicle.Speed;

public class Vehicle {

	interface Fly {
		public void height(int height);
	}

	interface Land {// land : 땅
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
		System.out.println("자동차의 스피드는 100km/h입니다.");
	}

	public void move(int x, int y) {
		System.out.printf("자동차는 %d, %d 좌표로 이동\n", x, y);
	}

	public void ride() {
		System.out.println("땅에서만 다닙니다");
	}

	public void wheel(int wheel) {
		System.out.println("자동차의 휠 개수는 " + wheel + "입니다.");
	}

}

class Airplane implements Fly, Speed {
	public void speed() {
		System.out.println("비행기의 스피드는 400km/h입니다.");
	}

	public void move(int x, int y) {
		System.out.printf("비행기는 %d, %d 좌표로 이동\n", x, y);
	}
	public void ride() {
		System.out.println("주로 하늘에서만 다닙니다");

	}
	public void height(int height) {
		System.out.println("비행기는 고도" + height + "km 상공을 다닙니다.");
	}
}
