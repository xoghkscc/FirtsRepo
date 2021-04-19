package myobj.item;

public class Shoes extends Item {
	private int speed;
	
	public int getSpeed() {
		return speed;
	}

	public Shoes(String name, int price) {
		super(name, price);
	}
	
	public void speed(int speed) {
		this.speed = speed;
	}
	
	public void use() {
		System.out.println("신발을 장착해서 " + speed+" 만큼 빨라졌습니다.");
	}

	
}
