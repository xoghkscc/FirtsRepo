import java.io.ObjectInputStream.GetField;

public class C10_LocalInnerClass {
	
	public static void main(String[] args) {
		class Apple{
			String size;
			String color;
			String insect;
			
		}
		
		Apple a = new Apple();
		AppleBox.Apple a2 = new AppleBox("���� �ڽ�").new Apple();
		
		//���� ���� Ŭ������ ��ĳ���� �Ǿ��ִ� ����
		Fruit2 banana =getSomething(); //(new Banana(20)
		
		banana.eat();
		
		
		
	}
	
	public static Fruit2 getSomething() {
		class Banana extends Fruit2{
			int fruit;
			int[] color;
			
			public Banana(int fruit) {
				this.fruit = fruit;
			}
			
			void eat() {
				System.out.println("���Ű� " +fruit + "�� ���� �ٳ����� ���մ�");
			}
			
		}
		
		return new Banana(20);
	}
	
}

abstract class Fruit2{
	abstract void eat();
}
