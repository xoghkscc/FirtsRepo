package myobj.item;

public class Candy extends Item {
	
	int healthy;
	
	public Candy(String name, int price) {
		super(name, price);
		healthy = 10;
	}
	
	public void use() {
		System.out.println("사탕을 먹허서" + healthy+"만큼 목 건강이 좋아졌습니다.");
	}

}
