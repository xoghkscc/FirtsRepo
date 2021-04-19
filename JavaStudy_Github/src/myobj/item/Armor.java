package myobj.item;

public class Armor extends Item{
	private int armor=0;
	
	public int getArmor() {
		return armor;
	}

	public Armor(String name, int price) {
		super(name, price);
	}
	
	public void armor(int armor) {
		this.armor = armor;
	}
	
	public void use() {
		System.out.println("방어구를 장착해서 " + armor+ "만큼 단단해졌습니다.");
	}

}
