import java.io.ObjectInputStream.GetField;

public class C10_LocalInnerClass {
	
	public static void main(String[] args) {
		class Apple{
			String size;
			String color;
			String insect;
			
		}
		
		Apple a = new Apple();
		AppleBox.Apple a2 = new AppleBox("고구마 박스").new Apple();
		
		//내부 지역 클래스가 업캐스팅 되어있는 상태
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
				System.out.println("열매가 " +fruit + "개 열린 바나나는 맛잇다");
			}
			
		}
		
		return new Banana(20);
	}
	
}

abstract class Fruit2{
	abstract void eat();
}
