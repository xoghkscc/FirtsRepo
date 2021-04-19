import myobj.GalaxyTabs5e;

public class C04_Static {
	public static void main(String[] args) {
		
//		Lamp lamp01 = new Lamp();
//		Lamp lamp02 = new Lamp();
//		Lamp lamp03 = new Lamp();
//		Lamp lamp04 = new Lamp();
//		
//		System.out.println(Lamp.width);//-->50
//		System.out.println(lamp01.width);//-->50
//		System.out.println(lamp02.width);//-->50
//		lamp01.width = 30;
//		System.out.println(lamp03.width);//-->30
//		System.out.println(lamp04.width);//-->30
//		System.out.println(Lamp.width);//-->30
		GalaxyTabs5e price = new GalaxyTabs5e();
		
		System.out.println("갤럭시탭s5e의 화면 크기 : "+ GalaxyTabs5e.screenSize);
		System.out.println("갤럭시탭s5e의 램 크기 : "+ GalaxyTabs5e.ram);
		System.out.println("갤럭시탭s5e의 메모리 크기 : "+ GalaxyTabs5e.memory);
		System.out.println("갤럭시탭s5e의 g마켓 가격 : "+ price.getGmarketPrice());
		System.out.println("갤럭시탭s5e의 옥션 가격 : "+ price.getAuctionPrice());
		System.out.println("갤럭시탭s5e의 인터파크 가격 : "+ price.getInterparkPrice());
	}
}

class Lamp {
	// 강의장 내부의 모든 형광등의 너비와 높이는 일정하다
	static int width = 50;
	static int height = 200;
	int[] position;
	double brightnness;
	boolean powerOn;
	
	//static 메서드에서 staitc 변수에 접근하는 것은 가능
	public static void changeWidth(int width) {
		Lamp.width = width;
	}
	//메인함수에서 Lamp.turnOn();을 사용할 수 있으므로 static 메서드에서는 인스턴스 자원(position, powerOn, brightnness)을 사용할 수 없다.
	static void turnOn() {
//		this.powerOn = true;
	}
}

//myobj 패키지에 static 변수를 포함한 클래스를 하나 정의 해보세요.
