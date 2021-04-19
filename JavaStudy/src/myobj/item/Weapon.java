package myobj.item;

public class Weapon extends Item {
	 int atk=0;
	
	public Weapon(String name, int price, int atk) {
		super(name, price);
		this.atk = atk;
	}
	
	public int getAtk() {
		return atk;
	}

	public void use() {
		System.out.println("무기를 장착해서 " + atk+" 만큼 강해졌습니다.");
	}
	
}
