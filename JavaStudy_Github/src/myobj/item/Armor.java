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
		System.out.println("���� �����ؼ� " + armor+ "��ŭ �ܴ��������ϴ�.");
	}

}
