
public class C09_innerClass {
	public static void main(String[] args) {
		AppleBox box = new AppleBox("�ֹڽ�");
		
		//�̳� Ŭ���� �ν��Ͻ� �����ϱ�
		AppleBox.Apple apple1 = new AppleBox("����ڽ�").new Apple();
		AppleBox.Apple apple2 = box.new Apple();
		
		apple1.whereAmI();
		apple2.whereAmI();
	}
}

class AppleBox{
	
	Apple[] box;
	String boxName;
	
	public AppleBox(String name) {
		box = new Apple[10];
		
		for (int i = 0; i < box.length; i++) {
			box[i] = new Apple();
		}
		boxName = name;
	}
	
	
	
	class Apple{
		String color;
		int size=10;
		boolean insect;
		
		void whereAmI() {
			System.out.println(boxName);
		}
	}
	
}