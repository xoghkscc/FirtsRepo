import myobj.etc.GalaxyTabs5e;

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
		
		System.out.println("��������s5e�� ȭ�� ũ�� : "+ GalaxyTabs5e.screenSize);
		System.out.println("��������s5e�� �� ũ�� : "+ GalaxyTabs5e.ram);
		System.out.println("��������s5e�� �޸� ũ�� : "+ GalaxyTabs5e.memory);
		System.out.println("��������s5e�� g���� ���� : "+ price.getGmarketPrice());
		System.out.println("��������s5e�� ���� ���� : "+ price.getAuctionPrice());
		System.out.println("��������s5e�� ������ũ ���� : "+ price.getInterparkPrice());
	}
}

class Lamp {
	// ������ ������ ��� �������� �ʺ�� ���̴� �����ϴ�
	static int width = 50;
	static int height = 200;
	int[] position;
	double brightnness;
	boolean powerOn;
	
	//static �޼��忡�� staitc ������ �����ϴ� ���� ����
	public static void changeWidth(int width) {
		Lamp.width = width;
	}
	//�����Լ����� Lamp.turnOn();�� ����� �� �����Ƿ� static �޼��忡���� �ν��Ͻ� �ڿ�(position, powerOn, brightnness)�� ����� �� ����.
	static void turnOn() {
//		this.powerOn = true;
	}
}

//myobj ��Ű���� static ������ ������ Ŭ������ �ϳ� ���� �غ�����.
